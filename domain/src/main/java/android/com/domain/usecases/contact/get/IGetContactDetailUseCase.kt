package android.com.domain.usecases.contact.get

import android.com.domain.entities.Contact
import io.reactivex.Single

interface IGetContactDetailUseCase {
    fun getContactById(id: String): Single<Contact>
}