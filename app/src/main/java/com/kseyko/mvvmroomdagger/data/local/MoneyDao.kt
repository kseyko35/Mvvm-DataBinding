package com.kseyko.mvvmroomdagger.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import kotlinx.coroutines.flow.Flow


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      07,February,2021      ║
╚════════════════════════════╝
 */
@Dao
interface MoneyDao { //Data Access Objects are the main classes where we define our database interactions.
    // They can include a variety of query methods. such as delete query and Insert
    @Query("select * from money")
    fun getMoney(): Flow<List<MoneyModel>>//with flow, whenever a money in the database is updated, then the entire list of money is emitted again.

    @Insert
    suspend fun insertAllMoney(moneyModelList: List<MoneyModel>)

    @Query("Delete from money")
    suspend fun deleteAllMoney()


}