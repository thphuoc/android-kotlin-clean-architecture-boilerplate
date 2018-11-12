package android.com.domain.usecases.contact.remove

import io.reactivex.Single

class RemoveContactUseCase : IRemoveContactUseCase {
    override fun removeContactById(id: String): Single<Boolean> {
        return Single.just(true)
    }
}