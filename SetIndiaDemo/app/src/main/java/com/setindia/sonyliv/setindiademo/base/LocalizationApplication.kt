package com.setindia.sonyliv.setindiademo.base

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.setindia.sonyliv.setindiademo.model.ParseLocalizedJson
import com.setindia.sonyliv.setindiademo.model.ReadFromFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

/*
    author: ritesh
    date: 16 May 2021
 */
class LocalizationApplication : Application() {
    private var parseLocalizationJson: String? = null
    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.IO).launch {
            fetchJsonFromCloud()
        }
    }

    private suspend fun fetchJsonFromCloud() {
        // url to download json data
        val url:URL? = try {
            URL("https://pastebin.com/raw/c7KrRbBL#")
        }catch (e: MalformedURLException){
            Log.d("Exception", e.toString())
            null
        }

        val parseLocalizationJson : String? = url?.getString()
        parseLocalizationJson?.apply {
            readAndPraseLocalization(parseLocalizationJson)
        }
    }

    // extension function to get string data from url
    fun URL.getString(): String? {
        val stream = openStream()
        return try {
            val r = BufferedReader(InputStreamReader(stream))
            val result = StringBuilder()
            var line: String?
            while (r.readLine().also { line = it } != null) {
                result.append(line).appendln()
            }
            result.toString()
        }catch (e: IOException){
            e.toString()
        }
    }


    private suspend fun readAndPraseLocalization(parseLocalizationJson: String?) {
        try {
//            parseLocalizationJson = ReadFromFile.readFromAssets(this, "set-india-localization.txt")
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