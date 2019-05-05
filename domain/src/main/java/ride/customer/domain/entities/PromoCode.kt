package ride.customer.domain.entities

import java.util.*

data class PromoCode (val code: String?,
                      val validFrom: Date?,
                      val validTo: Date?,
                      val discountValue: Int?,
                      val limitDiscountValue: Int?,
                      val percentageDiscountValue: Int?,
                      val maxUseCount: Int?,
                      val targetVehicleTypes: Array<String>?,
                      val targetPaymentMethods: Array<String>?,
                      val startRegion: Array<Array<Double>>?,
                      val endRegion: Array<Array<Double>>?,
                      val startRegionName: String?,
                      val endRegionName: String?,
                      val appliedFor: Array<User>,
                      val shortDescription: String?,
                      val fullDescription: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PromoCode

        if (targetVehicleTypes != null) {
            if (other.targetVehicleTypes == null) return false
            if (!targetVehicleTypes.contentEquals(other.targetVehicleTypes)) return false
        } else if (other.targetVehicleTypes != null) return false
        if (targetPaymentMethods != null) {
            if (other.targetPaymentMethods == null) return false
            if (!targetPaymentMethods.contentEquals(other.targetPaymentMethods)) return false
        } else if (other.targetPaymentMethods != null) return false
        if (startRegion != null) {
            if (other.startRegion == null) return false
            if (!startRegion.contentDeepEquals(other.startRegion)) return false
        } else if (other.startRegion != null) return false
        if (endRegion != null) {
            if (other.endRegion == null) return false
            if (!endRegion.contentDeepEquals(other.endRegion)) return false
        } else if (other.endRegion != null) return false
        if (!appliedFor.contentEquals(other.appliedFor)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = targetVehicleTypes?.contentHashCode() ?: 0
        result = 31 * result + (targetPaymentMethods?.contentHashCode() ?: 0)
        result = 31 * result + (startRegion?.contentDeepHashCode() ?: 0)
        result = 31 * result + (endRegion?.contentDeepHashCode() ?: 0)
        result = 31 * result + appliedFor.contentHashCode()
        return result
    }
}