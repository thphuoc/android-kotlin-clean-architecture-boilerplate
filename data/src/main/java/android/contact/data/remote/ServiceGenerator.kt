package android.contact.data.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator private constructor(private val retrofit: Retrofit) {
    class Builder {
        private var isDebug: Boolean = false
        private var baseUrl: String = ""

        fun debug(isDebug: Boolean): Builder {
            this.isDebug = isDebug
            return this
        }

        fun baseUrl(url: String): Builder {
            this.baseUrl = url
            return this
        }

        fun build(): ServiceGenerator {
            val okHttpClient = makeOkHttpClient(
                    makeLoggingInterceptor(isDebug))
            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(makeGson()))
                    .build()
            return ServiceGenerator(retrofit)
        }

        private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(RemoteConfig.CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
                    .readTimeout(RemoteConfig.READ_TIMEOUT_SEC, TimeUnit.SECONDS)
                    .build()
        }

        private fun makeGson(): Gson {
            return GsonBuilder()
                    .setLenient()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
        }

        private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level = if (isDebug)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
            return logging
        }
    }

    fun <T> generate(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}