package android.com.remote.services

import android.com.remote.models.entries.ContactEntity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ContactService {
    @GET("/contact")
    fun getContactById(@Query("id") id: String): Single<ContactEntity>

    @POST("/remove")
    fun removeContactById(@Query("id") id: String): Single<Boolean>

    @GET("/list")
    fun getContactList(): Observable<List<ContactEntity>>
}