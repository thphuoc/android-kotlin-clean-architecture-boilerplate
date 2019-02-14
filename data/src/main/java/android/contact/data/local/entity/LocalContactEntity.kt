package android.contact.data.local.entity

import android.net.Uri
import java.util.*

data class LocalContactEntity(val id: Long,
                              val avatar: Uri,
                              val displayName: String,
                              val primaryPhoneNo: String,
                              val secondaryPhoneNo: String,
                              val dob: Date,
                              val email: String,
                              val address: String,
                              val latitude: Double,
                              val longitude: Double,
                              val ringTuneUri: Uri,
                              val bankAccountEntities: List<BankAccountEntity>,
                              val groupName: String,
                              val groupId: Int)