package com.kseyko.mvvmroomdagger.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kseyko.mvvmroomdagger.data.model.MoneyModel


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      07,February,2021      ║
╚════════════════════════════╝
 */
@Database(entities = [MoneyModel::class], version = 1, exportSchema = false)
abstract class MoneyDatabase : RoomDatabase() {
    abstract fun moneyDao(): MoneyDao
}