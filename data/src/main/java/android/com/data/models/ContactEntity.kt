package android.com.data.models

import com.sun.xml.internal.ws.developer.Serialization

data class ContactEntity(@Serialization(encoding = "id") val id: String,
                         @Serialization(encoding = "firstName") val firstName: String,
                         @Serialization(encoding = "lastName") val lastName: String,
                         @Serialization(encoding = "email") val email: String,
                         @Serialization(encoding = "mobile") val mobile: String)