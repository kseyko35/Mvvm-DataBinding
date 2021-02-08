package com.kseyko.mvvmroomdagger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      06,February,2021      ║
╚════════════════════════════╝
 */
@Entity(tableName = "money")
data class MoneyModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currency: String,
    val price: String
)