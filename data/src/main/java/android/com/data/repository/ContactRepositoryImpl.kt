package android.com.data.repository

import android.com.data.interactor.ContactRemote
import android.com.domain.entities.Contact
import android.com.domain.repository.ContactRepository
import io.reactivex.Single

class ContactRepositoryImpl(private val remote: ContactRemote) : ContactRepository {

    override fun getContactById(id: String): Single<Contact> {
        return remote.getContactById(id)
    }

    override fun getContactList(): Single<List<Contact>> {
        return remote.getContactList()
    }

    override fun removeContactById(id: String): Single<Boolean> {
        return remote.removeContactById(id)
    }
}