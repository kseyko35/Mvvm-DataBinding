package com.kseyko.mvvmroomdagger.di.module

import com.kseyko.mvvmroomdagger.data.network.MoneyApi
import com.kseyko.mvvmroomdagger.util.Credentials
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
@InstallIn(SingletonComponent::class) // We use installin annotation to provide component which we want to use.
object MoneyApiModule {

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun createApi(retrofit: Retrofit): MoneyApi =
        retrofit.create(MoneyApi::class.java)

}