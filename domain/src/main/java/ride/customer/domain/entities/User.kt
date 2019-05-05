package ride.customer.domain.entities

data class User (val fullName: String?,
                 val phoneNumber: String?,
                 val isDriver: Boolean = false,
                 val isBot: Boolean = false,
                 val isDocumentVerified: Boolean = false)