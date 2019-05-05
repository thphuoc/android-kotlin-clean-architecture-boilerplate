package ride.customer.data.repository

import android.customer.domain.entities.Contact
import android.customer.data.remote.models.entries.ContactEntity

fun ContactEntity.toContact(): Contact {
    return Contact(id, firstName.plus(lastName), email, mobile)
}