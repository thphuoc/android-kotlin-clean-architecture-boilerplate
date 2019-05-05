package ride.customer.domain.entities

data class SurgeRegion(val region: Array<Array<Double>>,
                       val city: String?,
                       val district: String?,
                       val ward: String?,
                       val relationId: String?) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SurgeRegion

        if (!region.contentDeepEquals(other.region)) return false

        return true
    }

    override fun hashCode(): Int {
        return region.contentDeepHashCode()
    }
}