package com.pixelart.testroommvpanddagger.data.dao

import android.arch.persistence.room.*
import com.pixelart.testroommvpanddagger.model.FavoriteCelebrity

@Dao
interface CelebrityDao{

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertCelebrity(favoriteCelebrity: FavoriteCelebrity)

    @Update
    fun updateCelebrity(favoriteCelebrity: FavoriteCelebrity)

    @Query("SELECT * FROM celebrities ORDER BY name ASC")
    fun getCelebrities():List<FavoriteCelebrity>
}