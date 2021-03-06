package com.setindia.sonyliv.setindiademo.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
    author: ritesh
    date: 16 May 2021
 */
@Dao
public interface LocalizationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LocalizationEntity entity);

    @Update
    void update(LocalizationEntity entity);

    @Delete
    void delete(LocalizationEntity entity);

    @Query("DELETE FROM " + Constants.LOCALIZATION_TABLE)
    void deleteAllEnteries();

    @Query("SELECT * FROM " + Constants.LOCALIZATION_TABLE)
    LiveData<List<LocalizationEntity>> getAllEnteries();

    @Query("SELECT * FROM localization_table WHERE locale LIKE :locales" +
            " AND keyID LIKE :resKeys LIMIT 1")
    LocalizationEntity getOneEntryValue(String locales, String resKeys);
}