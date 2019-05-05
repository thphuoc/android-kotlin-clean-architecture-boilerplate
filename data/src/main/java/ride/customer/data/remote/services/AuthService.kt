package ride.customer.data.remote.services

import android.customer.data.remote.models.entries.ContactEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @GET("/contact")
    fun getContactById(@Query("id") id: String): Single<ContactEntity>

    @POST("/remove")
    fun removeContactById(@Query("id") id: String): Single<Boolean>

    @GET("/list")
    fun getContactList(): Single<List<ContactEntity>>
}