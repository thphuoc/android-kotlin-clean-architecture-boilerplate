package ride.customer.domain.entities

import java.util.*

data class Vehicle(val owner: User?,
                   val type: String?,
                   val brand: String?,
                   val plateNumber: String?,
                   val color: String?,
                   val colorHexValue: String?,
                   val year: String?,
                   val expiryDate: Date?,
                   val mapIconFile: String?,
                   val imageFile: String?)