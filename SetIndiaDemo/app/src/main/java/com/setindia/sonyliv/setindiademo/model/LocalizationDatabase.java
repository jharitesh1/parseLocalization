package com.setindia.sonyliv.setindiademo.model;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {LocalizationEntity.class}, version = 2)
public abstract class LocalizationDatabase extends RoomDatabase {

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE  LocalizationEntity"
                    + " ADD COLUMN last_update INTEGER");
        }
    };
    static final Migration MIGRATION_1_3 = new Migration(1, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("drop table  LocalizationEntity");
        }
    };
    private static LocalizationDatabase instance;

    public static synchronized LocalizationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalizationDatabase.class, Constants.LOCALIZATION_DATABASE)
                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_2_3, MIGRATION_1_3)
                    .build();
        }
        return instance;
    }

    public abstract LocalizationDao locaLizationDao();

//    private static Callback roomCallback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDbAsyncTask(instance).execute();
//
//        }
//    };

//    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private NoteDao noteDao;
//
//        private PopulateDbAsyncTask(LocalizationDatabase db) {
//            noteDao = db.noteDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            noteDao.insert(new NoteEntity("Title 1", "Description 1", 1));
//            noteDao.insert(new NoteEntity("Title 2", "Description 2", 2));
//            noteDao.insert(new NoteEntity("Title 3", "Description 3", 3));
//            return null;
//        }
//    }
}