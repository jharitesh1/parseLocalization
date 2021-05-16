package com.setindia.sonyliv.setindiademo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constants.LOCALIZATION_TABLE)
public class LocalizationEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private final String locale;
    @ColumnInfo(name = "keyID")
    private final String keyID;
    @ColumnInfo(name = "value")
    private final String value;

    public LocalizationEntity(String locale, String keyID, String value) {
        this.locale = locale;
        this.keyID = keyID;
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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