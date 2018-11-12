package android.com.domain.usecases.contact.get

import android.com.domain.entities.Contact
import io.reactivex.Single

class GetContactDetailUseCase: IGetContactDetailUseCase {
    override fun getContactById(id: String): Single<Contact> {
        return Single.just(Contact("1", "", "", "", ""))
    }
}