package android.com.remote

import android.com.data.models.ErrorEntity
import java.lang.Exception

data class RetrofitException(val errorEntity: ErrorEntity): Exception()