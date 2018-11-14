package android.com.data.interactor

import android.com.domain.entities.Contact
import io.reactivex.Observable

interface ContactLocal {
    fun getContactList(): Observable<List<Contact>>
}