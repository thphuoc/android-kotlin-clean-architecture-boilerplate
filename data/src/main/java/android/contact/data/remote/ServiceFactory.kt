package android.contact.data.remote

import android.contact.data.remote.services.ContactService

object ServiceFactory {
    fun getContactService(isDebug: Boolean, baseUrl: String): ContactService {
        return ServiceGenerator.Builder().baseUrl(baseUrl).debug(isDebug).build().generate(ContactService::class.java)
    }
}