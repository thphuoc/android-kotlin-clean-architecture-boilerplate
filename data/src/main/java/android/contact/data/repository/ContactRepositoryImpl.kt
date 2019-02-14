package android.contact.data.repository

import android.contact.data.local.LocalContactUtils
import android.contact.data.local.toContact
import android.contact.data.remote.services.ContactService
import android.contact.data.toContact
import android.contact.domain.entities.Contact
import android.contact.domain.repository.ContactRepository
import io.reactivex.Single

class ContactRepositoryImpl(private val contactService: ContactService,
                            private val localContactUtils: LocalContactUtils) : ContactRepository {

    override fun getContactById(id: String): Single<Contact> {
        return contactService.getContactById(id).map { it.toContact() }
    }

    override fun getAllContactFromLocal(): Single<List<Contact>> {
        return localContactUtils.getAllContact().flattenAsObservable { it }.map { it.toContact() }.toList()
    }

    override fun removeContactById(id: String): Single<Boolean> {
        return contactService.removeContactById(id)
    }

    override fun getAllContactFromServer(): Single<List<Contact>> {
        return contactService.getContactList().flatMapIterable { it }.map { it.toContact() }.toList()
    }
}