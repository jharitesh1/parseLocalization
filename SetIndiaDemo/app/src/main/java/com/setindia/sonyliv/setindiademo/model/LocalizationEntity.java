package com.setindia.sonyliv.setindiademo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    author: ritesh
    date: 16 May 2021
 */
@Entity(tableName = Constants.LOCALIZATION_TABLE)
public class LocalizationEntity {

    private final String locale;
    private final String keyID;
    @ColumnInfo(name = "value")
    private final String value;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public LocalizationEntity(String locale, String keyID, String value) {
        this.locale = locale;
        this.keyID = keyID;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public String getKeyID() {
        return keyID;
    }

    public String getValue() {
        return value;
    }
}