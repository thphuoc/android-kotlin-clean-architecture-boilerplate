package android.contact.domain.usecases

import android.contact.domain.entities.Contact
import android.contact.domain.repository.ContactRepository
import io.reactivex.Single

class GetContactDetailUseCase(repo: ContactRepository) {
    fun getContactById(id: String): Single<Contact> {
        return Single.just(Contact("1", "", "", "", ""))
    }
}