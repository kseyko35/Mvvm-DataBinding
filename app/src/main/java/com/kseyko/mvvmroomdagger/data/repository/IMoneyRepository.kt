package com.kseyko.mvvmroomdagger.data.repository

import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import com.kseyko.mvvmroomdagger.util.Resource
import kotlinx.coroutines.flow.Flow


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      08,February,2021      ║
╚════════════════════════════╝
 */
interface IMoneyRepository {
    fun fetchMoneyFromApi(): Flow<Resource<List<MoneyModel>>>
    fun fetchMoneyFromDb(): Flow<List<MoneyModel>>
    suspend fun deleteMoneyFromDb()
    suspend fun insertAllMoney(moneyList: List<MoneyModel>)

}