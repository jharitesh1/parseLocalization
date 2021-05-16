package com.setindia.sonyliv.setindiademo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.setindia.sonyliv.setindiademo.R
import com.setindia.sonyliv.setindiademo.model.LocalizationViewModel
import com.setindia.sonyliv.setindiademo.model.ParseLocalizedJson
import com.setindia.sonyliv.setindiademo.model.ReadFromFile


class SetIndiaMainScreenActivity : AppCompatActivity() {
    private val TAG = SetIndiaMainScreenActivity::class.simpleName
//    private val LocalizationViewModel viewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonFile: String? = ReadFromFile.readFromAssets(this, "set-india-localization.txt")
        Log.i(TAG, "jsonFile : " + jsonFile)
        if (!jsonFile.isNullOrEmpty()) ParseLocalizedJson.parseLocalizationJson(jsonFile)

//        viewModel = ViewModelProviders.of(this).get(LocalizationViewModel::class.java)
    }


}