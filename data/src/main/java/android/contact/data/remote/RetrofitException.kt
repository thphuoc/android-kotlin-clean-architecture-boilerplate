package android.contact.data.remote

import android.contact.data.remote.models.entries.ErrorEntity
import java.lang.Exception

data class RetrofitException(val errorEntity: ErrorEntity): Exception()