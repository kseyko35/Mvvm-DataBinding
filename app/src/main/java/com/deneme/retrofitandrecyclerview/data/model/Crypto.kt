package com.deneme.retrofitandrecyclerview.data.model

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
@Entity(tableName = "crypto")
data class Crypto(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val currency: String,
    val price:String
)