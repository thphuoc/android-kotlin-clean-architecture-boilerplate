package android.com.domain.repository

import android.com.domain.entities.Contact
import io.reactivex.Observable
import io.reactivex.Single

interface ContactRepository {
    fun getContactById(id: String): Single<Contact>
    fun getContactList(): Observable<List<Contact>>
    fun removeContactById(id: String): Single<Boolean>
}