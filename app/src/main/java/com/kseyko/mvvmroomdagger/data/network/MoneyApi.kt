package com.kseyko.mvvmroomdagger.data.network

import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      07,February,2021      ║
╚════════════════════════════╝
 */

interface MoneyApi {
    @GET("prices")
    suspend fun getAllMoney(@Query("key") key: String): Response<List<MoneyModel>>
}