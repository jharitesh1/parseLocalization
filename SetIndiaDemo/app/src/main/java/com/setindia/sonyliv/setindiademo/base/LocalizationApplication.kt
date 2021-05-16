package com.setindia.sonyliv.setindiademo.base

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.setindia.sonyliv.setindiademo.model.ParseLocalizedJson
import com.setindia.sonyliv.setindiademo.model.ReadFromFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class LocalizationApplication : Application() {
    private var parseLocalizationJson: String? = null
    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.Default).launch {
            readAndPraseLocalization()
        }

    }

    private suspend fun readAndPraseLocalization() {
        try {
            parseLocalizationJson = ReadFromFile.readFromAssets(this, "set-india-localization.txt")
            Log.i(TAG, "jsonFile : $parseLocalizationJson")
            if (!TextUtils.isEmpty(parseLocalizationJson)) {
                val parseLocalizedJson = ParseLocalizedJson(this)
                parseLocalizedJson.parseLocalizationJson(parseLocalizationJson)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        private val TAG = LocalizationApplication::class.java.simpleName
    }
}