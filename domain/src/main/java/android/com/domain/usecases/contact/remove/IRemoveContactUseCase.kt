package android.com.domain.usecases.contact.remove

import io.reactivex.Single

interface IRemoveContactUseCase {
    fun removeContactById(id: String): Single<Boolean>
}