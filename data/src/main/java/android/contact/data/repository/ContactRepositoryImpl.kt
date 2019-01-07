package android.contact.data.repository

import android.contact.data.interactor.ContactRemote
import android.contact.domain.entities.Contact
import android.contact.domain.repository.ContactRepository
import io.reactivex.Observable
import io.reactivex.Single

class ContactRepositoryImpl(private val remote: ContactRemote) : ContactRepository {

    override fun getContactById(id: String): Single<Contact> {
        return remote.getContactById(id)
    }

    override fun getContactList(): Observable<List<Contact>> {
        return remote.getContactList()
    }

    override fun removeContactById(id: String): Single<Boolean> {
        return remote.removeContactById(id)
    }
}