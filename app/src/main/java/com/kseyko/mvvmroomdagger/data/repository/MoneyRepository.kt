package com.kseyko.mvvmroomdagger.data.repository

import com.kseyko.mvvmroomdagger.data.local.MoneyDao
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import com.kseyko.mvvmroomdagger.data.network.MoneyApi
import com.kseyko.mvvmroomdagger.util.Credentials
import com.kseyko.mvvmroomdagger.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import java.lang.Exception
import javax.inject.Inject


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      08,February,2021      ║
╚════════════════════════════╝
 */
class MoneyRepository @Inject constructor(
    private val db: MoneyDao,
    private val api: MoneyApi
) : IMoneyRepository {
    override fun fetchMoneyFromApi(): Flow<Resource<List<MoneyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getAllMoney(Credentials.KEY)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                    insertAllMoney(it)
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage.toString()))
            e.printStackTrace()
        }
    }

    override fun fetchMoneyFromDb(): Flow<List<MoneyModel>> = db.getMoney()


    override suspend fun deleteMoneyFromDb() = db.deleteAllMoney()

    override suspend fun insertAllMoney(moneyList: List<MoneyModel>) = db.insertAllMoney(moneyList)

}