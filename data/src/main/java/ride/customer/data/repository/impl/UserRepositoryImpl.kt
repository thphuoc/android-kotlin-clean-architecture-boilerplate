package ride.customer.data.repository.impl

import io.reactivex.Single

class UserRepositoryImpl(private val contactService: ContactService) : ContactRepository {

    override fun getContactById(id: String): Single<Contact> {
        return contactService.getContactById(id).map { it.toContact() }
    }

    override fun removeContactById(id: String): Single<Boolean> {
        return contactService.removeContactById(id)
    }

    override fun getAllContact(): Single<List<Contact>> {
        return contactService.getContactList().flattenAsObservable { it }.map { it.toContact() }.toList()
    }
}