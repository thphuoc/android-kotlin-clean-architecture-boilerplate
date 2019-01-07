package android.contact.remote

import android.contact.remote.models.entries.ErrorEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type


internal class RxErrorHandlingCallAdapterFactory private constructor() : CallAdapter.Factory() {
    private val original: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<Any, Any> {
        return RxCallAdapterWrapper((original.get(returnType, annotations, retrofit) as CallAdapter<Any, Any>?)!!)
    }

    private class RxCallAdapterWrapper(private val wrapped: CallAdapter<Any, Any>) : CallAdapter<Any, Any> {

        override fun responseType(): Type {
            return wrapped.responseType()
        }

        override fun adapt(call: Call<Any>): Any {
            val result = wrapped.adapt(call)
            if (result is Single<*>) return result.onErrorResumeNext {
                Single.error(asRetrofitException(it))
            }
            if (result is Observable<*>) return result.onErrorResumeNext(Function {
                Observable.error(asRetrofitException(it))
            }
            )

            return if (result is Completable) {
                result.onErrorResumeNext {
                    Completable.error(asRetrofitException(it))
                }
            } else result

        }

        private fun asRetrofitException(throwable: Throwable): RetrofitException {
            // We had non-200 http error
            if (throwable is HttpException) {
                val response = throwable.response()
                return RetrofitException(ErrorEntity(response.code(), response.message()))
            }
            // A network error happened
            return if (throwable is IOException) {
                RetrofitException(ErrorEntity(NETWORK_ERROR_CODE, "Network error"))
            } else {
                RetrofitException(ErrorEntity(UNKNOWN_ERROR_CODE, "Unknown error"))
            }
        }
    }

    companion object {
        private const val NETWORK_ERROR_CODE = -1
        private const val UNKNOWN_ERROR_CODE = 0

        fun create(): CallAdapter.Factory {
            return RxErrorHandlingCallAdapterFactory()
        }
    }
}