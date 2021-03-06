package com.kseyko.mvvmroomdagger.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      06,February,2021      ║
╚════════════════════════════╝
 */
@Parcelize
@Entity(tableName = "money")
data class MoneyModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currency: String,
    val price: String
) : Parcelable