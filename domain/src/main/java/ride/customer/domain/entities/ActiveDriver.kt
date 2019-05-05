package ride.customer.domain.entities

import ride.customer.domain.entities._enum.VehicleType

data class ActiveDriver(val driver: User?,
                        val ride: Ride?,
                        val nextRide: Ride?,
                        val nextRideAccepted: Boolean,
                        val vehicleType: VehicleType?,
                        val location: GeoPoint?,
                        val speed: Int?,
                        val direction: Int?,
                        val status: String?,
                        val route: String?,
                        val eta: Int?,
                        val etaString: String?)