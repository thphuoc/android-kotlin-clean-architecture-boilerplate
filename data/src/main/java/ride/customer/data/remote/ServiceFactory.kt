package ride.customer.data.remote

import android.customer.data.remote.services.ContactService

object ServiceFactory {
    fun getContactService(isDebug: Boolean, baseUrl: String): ContactService {
        return ServiceGenerator.Builder().baseUrl(baseUrl).debug(isDebug).build().generate(ContactService::class.java)
    }
}