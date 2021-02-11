package com.kseyko.mvvmroomdagger.util

import androidx.room.RoomDatabase
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import java.lang.Exception
import javax.net.ssl.SSLEngineResult


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      08,February,2021      ║
╚════════════════════════════╝
 */
sealed class Resource<T>(
    val data: T?,
    val exception: String?,
    val status: Status
) {
    class Loading<T> : Resource<T>(null, null, Status.LOADING)
    class Success<T>(data: T?) : Resource<T>(data, null, Status.SUCCES)
    class Error<T>(exception: String?) : Resource<T>(null, exception, Status.ERROR)

}

enum class Status {
    LOADING,
    SUCCES,
    ERROR
}