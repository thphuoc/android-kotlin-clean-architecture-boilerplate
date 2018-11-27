package android.com.remote.services

import android.com.data.models.ContactEntity
import android.com.remote.ServiceEndpoint
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ContactService {
    @GET(ServiceEndpoint.GET_CONTACT_DETAIL)
    fun getContactById(@Query("id") id: String): Single<ContactEntity>

    @POST(ServiceEndpoint.REMOVE_CONTACT)
    fun removeContactById(@Query("id") id: String): Single<Boolean>

    @GET(ServiceEndpoint.LIST_CONTACT)
    fun getContactList(): Observable<List<ContactEntity>>
}