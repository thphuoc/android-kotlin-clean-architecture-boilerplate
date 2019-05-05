package ride.customer.domain.entities

data class VehicleFare (val name: String?="",
                        val vehicleType: String?,
                        val group: String?,
                        val iconFile: String?,
                        val baseFare: Double?,
                        val farePerKm: Double?,
                        val farePerMinute: Double?,
                        val visible: Boolean?)