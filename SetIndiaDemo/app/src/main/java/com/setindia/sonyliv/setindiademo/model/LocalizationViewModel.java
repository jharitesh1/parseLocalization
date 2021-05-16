package com.setindia.sonyliv.setindiademo.model;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class LocalizationViewModel extends AndroidViewModel {
    private final LocalizationRepository repository;
    private final LiveData<List<LocalizationEntity>> allEnteries;

    public LocalizationViewModel(@NonNull Application application) {
        super(application);
        repository = new LocalizationRepository(application);
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

    public LiveData<List<LocalizationEntity>> getAllEnteries() {
        return allEnteries;
    }
}