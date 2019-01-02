package android.com.remote

import android.com.remote.models.entries.ErrorEntity
import java.lang.Exception

data class RetrofitException(val errorEntity: ErrorEntity): Exception()