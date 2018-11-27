package android.com.domain.usecases

import android.com.domain.entities.Contact
import android.com.domain.repository.ContactRepository
import io.reactivex.Single

class GetContactDetailUseCase(repo: ContactRepository) {
    fun getContactById(id: String): Single<Contact> {
        return Single.just(Contact("1", "", "", "", ""))
    }
}