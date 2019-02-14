package android.contact.data.local

import android.annotation.SuppressLint
import android.contact.data.local.entity.LocalContactEntity
import android.content.Context
import android.net.Uri
import android.provider.ContactsContract
import io.reactivex.Observable
import io.reactivex.Single
import ir.mirrajabi.rxcontacts.RxContacts

class LocalContactUtils(private val context: Context) {
    fun getAllContact(): Single<List<LocalContactEntity>> {
        return RxContacts.fetch(context)
                .filter { it.inVisibleGroup == 1 }
                .map { it.toContactEntity() }
                .toList()
    }

    fun getContactById(contactId: Long): Observable<LocalContactEntity> {
        return RxContacts.fetch(context).filter { it.id == contactId }.map { it.toContactEntity() }
    }

    @SuppressLint("NewApi")
    fun removeContactById(contactId: Long): Single<Boolean> {
        val uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, "$contactId")
        val deleted = context.contentResolver.delete(uri, null, null)
        return Single.just(deleted > 0)
    }
}