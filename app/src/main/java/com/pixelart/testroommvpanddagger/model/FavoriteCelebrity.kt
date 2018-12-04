package com.pixelart.testroommvpanddagger.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.pixelart.testroommvpanddagger.common.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class FavoriteCelebrity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val typeOfCelebrity: String
)