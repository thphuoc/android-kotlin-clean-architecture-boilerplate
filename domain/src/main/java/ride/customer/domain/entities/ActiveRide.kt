package ride.customer.domain.entities

data class ActiveRide (val ride: Ride?,
                       val driver: User?,
                       val activeDriver: ActiveDriver?,
                       val toPoint: GeoPoint?,
                       val vehicleType: String?,
                       val eta: Int?,
                       val acceptNextRide: Boolean)