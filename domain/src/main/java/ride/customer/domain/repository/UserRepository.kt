package ride.customer.domain.repository

import io.reactivex.Single
import ride.customer.domain.entities.User

interface UserRepository {
    fun login(username: String, password: String): Single<User>
    fun register(username: String, password: String): Single<User>

}