package android.com.data.mapper

import android.com.data.models.ContactEntity
import android.com.domain.entities.Contact

fun ContactEntity.toContact(): Contact {
    return Contact(
            this.id,
            this.firstName,
            this.lastName,
            this.email,
            this.mobile
    )
}