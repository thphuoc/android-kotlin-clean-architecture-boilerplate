package android.com.remote

object ServiceEndpoint {
    private const val BASE_ENDPOINT = "https://base_url"
    const val BASE_CONTACT_ENDPOINT = "$BASE_ENDPOINT/contact"
    const val GET_CONTACT_DETAIL = "$BASE_CONTACT_ENDPOINT/id"
    const val REMOVE_CONTACT = "$BASE_CONTACT_ENDPOINT/id/remove"
    const val LIST_CONTACT = "$BASE_CONTACT_ENDPOINT/list"
}