package android.com.data.interactor

import android.com.domain.entities.Contact
import io.reactivex.Observable
import io.reactivex.Single

interface ContactRemote {
    fun getContactById(id: String): Single<Contact>
    fun getContactList(): Observable<List<Contact>>
    fun removeContactById(id: String): Single<Boolean>
}