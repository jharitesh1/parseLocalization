package com.setindia.sonyliv.setindiademo.viewmodel;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.setindia.sonyliv.setindiademo.model.LocalizationEntity;
import com.setindia.sonyliv.setindiademo.model.LocalizationRepository;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class LocalizationViewModel extends AndroidViewModel {
    private final LocalizationRepository repository;
    private final LiveData<List<LocalizationEntity>> allEnteries;
    private final LocalizationEntity entry;

    public LocalizationViewModel(@NonNull Application application, LocalizationEntity entry) {
        super(application);
        repository = new LocalizationRepository(application);
        this.entry = entry;
        allEnteries = repository.getAllEnteries();
    }

    public void insert(LocalizationEntity entity) {
        repository.insert(entity);
    }

    public void update(LocalizationEntity entity) {
        repository.update(entity);
    }

    public void delete(LocalizationEntity entity) {
        repository.delete(entity);
    }

    public void deleteAllEnteries() {
        repository.deleteAllEnteries();
    }

    public LocalizationEntity getOneEntry(String locale, String key) {
        return repository.getOneEntryValue(locale, key);
    }

    public LiveData<List<LocalizationEntity>> getAllEnteries() {
        return allEnteries;
    }
}