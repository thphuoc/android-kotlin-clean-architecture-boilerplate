package ride.customer.data.remote

import android.customer.data.remote.models.entries.ErrorEntity
import java.lang.Exception

data class RetrofitException(val errorEntity: ErrorEntity): Exception()