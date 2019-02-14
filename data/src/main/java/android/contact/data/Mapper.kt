package android.contact.data

import android.contact.domain.entities.Contact
import android.contact.data.remote.models.entries.ContactEntity

fun ContactEntity.toContact(): Contact {
    return Contact(id, firstName, lastName, email, mobile)
}