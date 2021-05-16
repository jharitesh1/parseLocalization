package com.setindia.sonyliv.setindiademo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.setindia.sonyliv.setindiademo.R
import com.setindia.sonyliv.setindiademo.model.LocalizationEntity
import com.setindia.sonyliv.setindiademo.model.LocalizationViewModel
import com.setindia.sonyliv.setindiademo.model.ParseLocalizedJson
import com.setindia.sonyliv.setindiademo.model.ReadFromFile


class SetIndiaMainScreenActivity : AppCompatActivity() {
    private val TAG = SetIndiaMainScreenActivity::class.simpleName
    lateinit var localizationViewModel: LocalizationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localizationViewModel = ViewModelProviders.of(this).get(LocalizationViewModel::class.java)
    }



}