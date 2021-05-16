package com.setindia.sonyliv.setindiademo.model;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.setindia.sonyliv.setindiademo.base.LocalizationApplication;

import java.util.List;

public class LocalizationRepository {
    private final LocalizationDao localizationDao;
    private final LiveData<List<LocalizationEntity>> allEnteries;

    public LocalizationRepository(Application application) {
        LocalizationDatabase database = LocalizationDatabase.getInstance(application);
        localizationDao = database.locaLizationDao();
        allEnteries = localizationDao.getAllEnteries();
    }

    public void insert(LocalizationEntity noteEntity) {
        new InsertAsync(localizationDao).execute(noteEntity);
    }

    public void update(LocalizationEntity noteEntity) {
        new UpdateAsync(localizationDao).execute(noteEntity);
    }

    public void delete(LocalizationEntity noteEntity) {
        new DeleteAsync(localizationDao).execute(noteEntity);
    }

    public void deleteAllEnteries() {
        new DeleteAllAsync(localizationDao).execute();
    }

    public LocalizationEntity getOneEntryValue(String locale, String key) {
        return localizationDao.getOneEntryValue(locale, key);
    }

    public LiveData<List<LocalizationEntity>> getAllEnteries() {
        return allEnteries;
    }

    private static class InsertAsync extends AsyncTask<LocalizationEntity, Void, Void> {
        private final LocalizationDao noteDao;

        private InsertAsync(LocalizationDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(LocalizationEntity... noteEntities) {
            noteDao.insert(noteEntities[0]);
            return null;
        }
    }

    private static class UpdateAsync extends AsyncTask<LocalizationEntity, Void, Void> {
        private final LocalizationDao noteDao;

        private UpdateAsync(LocalizationDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(LocalizationEntity... noteEntities) {
            noteDao.update(noteEntities[0]);
            return null;
        }
    }

    private static class DeleteAsync extends AsyncTask<LocalizationEntity, Void, Void> {
        private final LocalizationDao noteDao;

        private DeleteAsync(LocalizationDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(LocalizationEntity... noteEntities) {
            noteDao.delete(noteEntities[0]);
            return null;
        }
    }

    private static class DeleteAllAsync extends AsyncTask<Void, Void, Void> {
        private final LocalizationDao noteDao;

        private DeleteAllAsync(LocalizationDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllEnteries();
            return null;
        }
    }
}