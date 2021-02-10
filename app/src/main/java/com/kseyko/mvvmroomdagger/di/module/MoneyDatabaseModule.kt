package com.kseyko.mvvmroomdagger.di.module

import android.content.Context
import androidx.room.Room
import com.kseyko.mvvmroomdagger.data.local.MoneyDao
import com.kseyko.mvvmroomdagger.data.local.MoneyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      08,February,2021      ║
╚════════════════════════════╝
 */
@Module
@InstallIn(SingletonComponent::class)
object MoneyDatabaseModule {

    @Provides
    @Singleton
    fun moneyDatabase(@ApplicationContext context: Context): MoneyDatabase =
        Room.databaseBuilder(context, MoneyDatabase::class.java, "money.db").build()

    @Provides
    @Singleton
    fun moneyDao(moneyDatabase: MoneyDatabase): MoneyDao =
        moneyDatabase.moneyDao()
}