package android.com.remote.repository

import android.com.data.interactor.ContactRemote
import android.com.data.mapper.toContact
import android.com.domain.entities.Contact
import android.com.remote.services.ContactService
import io.reactivex.Observable
import io.reactivex.Single

class ContactRemoteImpl(private val service: ContactService) : ContactRemote {

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