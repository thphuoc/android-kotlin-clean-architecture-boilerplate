package ride.customer.domain.usecases

import android.customer.domain.entities.Contact
import android.customer.domain.repository.ContactRepository
import io.reactivex.Single

class GetContactDetailUseCase(private val repo: ContactRepository) {
    fun getContactById(id: String): Single<Contact> {
        return repo.getContactById(id)
    }
}