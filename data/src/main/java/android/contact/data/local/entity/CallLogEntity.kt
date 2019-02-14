package android.contact.data.local.entity

import java.util.*

data class CallLogEntity(private val id: String,
                         private val contactId: String,
                         private val protocolType: ProtocolType,
                         private val startTime: Date,
                         private val endTime: Date,
                         private val status: CallStatus,
                         private val fromNumber: String,
                         private val toNumber: String,
                         private val contactName: String,
                         private val contactAvatar: String)