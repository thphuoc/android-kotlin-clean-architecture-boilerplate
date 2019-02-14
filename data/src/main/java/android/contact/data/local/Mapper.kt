package android.contact.data.local

import android.contact.data.local.entity.LocalContactEntity
import android.net.Uri
import ir.mirrajabi.rxcontacts.Contact
import java.util.*
import kotlin.collections.ArrayList

fun Contact.toContactEntity(): LocalContactEntity {
    return LocalContactEntity(
            id,
            thumbnail,
            displayName,
            phoneNumbers.first(),
            phoneNumbers.last(),
            Date(), "","", 0.0, 0.0,
            Uri.EMPTY, ArrayList(), "", -1)
}

fun LocalContactEntity.toContact(): android.contact.domain.entities.Contact {
    return android.contact.domain.entities.Contact(
            "$id", displayName, email, primaryPhoneNo
    )
}