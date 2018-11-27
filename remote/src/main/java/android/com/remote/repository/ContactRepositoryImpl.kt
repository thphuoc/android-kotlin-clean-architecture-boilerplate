package android.com.remote.repository

import android.com.data.interactor.ContactRemote
import android.com.data.mapper.toContact
import android.com.domain.entities.Contact
import android.com.remote.ServiceEndpoint
import android.com.remote.services.ContactService
import android.com.remote.ServiceGenerator
import io.reactivex.Observable
import io.reactivex.Single

class ContactRepositoryImpl(isDebug: Boolean) : ContactRemote {

    private val service: ContactService = ServiceGenerator
            .Builder()
            .baseUrl(ServiceEndpoint.BASE_CONTACT_ENDPOINT)
            .debug(isDebug)
            .build()
            .generate()

    override fun getContactById(id: String): Single<Contact> {
        return service.getContactById(id).map { it.toContact() }
    }

    override fun getContactList(): Observable<List<Contact>> {
        return service.getContactList().map { it -> it.map { it.toContact() } }
    }

    override fun removeContactById(id: String): Single<Boolean> {
        return service.removeContactById(id)
    }
}