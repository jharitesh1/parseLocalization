package com.setindia.sonyliv.setindiademo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constants.LOCALIZATION_TABLE)
public class LocalizationEntity {

    private final String locale;
    @ColumnInfo(name = "key")
    private final String key;
    @ColumnInfo(name = "value")
    private final String value;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public LocalizationEntity(String locale, String key, String value) {
        this.locale = locale;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}