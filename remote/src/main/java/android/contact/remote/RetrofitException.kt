package android.contact.remote

import android.contact.remote.models.entries.ErrorEntity
import java.lang.Exception

data class RetrofitException(val errorEntity: ErrorEntity): Exception()