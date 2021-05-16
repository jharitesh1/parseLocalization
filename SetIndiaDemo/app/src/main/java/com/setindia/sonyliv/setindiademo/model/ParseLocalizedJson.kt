package com.setindia.sonyliv.setindiademo.model

import android.content.Context
import android.util.Log
import org.json.JSONException
import org.json.JSONObject

/*
    author: ritesh
    date: 16 May 2021
 */
class ParseLocalizedJson(val appContext: Context) {
    private val TAG = ParseLocalizedJson::class.simpleName
    private val JSON_LOCALIZATION = "localization"
    private val JSON_TYPE = "type"
    private val JSON_KEY = "keyID"
    private val JSON_VALUE = "value"
    val database = LocalizationDatabase.getInstance(appContext)
    val dao: LocalizationDao = database.locaLizationDao()

    fun parseLocalizationJson(jsonFile: String?) {
        try {
            val obj = JSONObject(jsonFile)
            val localizationArray = obj.optJSONArray(JSON_LOCALIZATION)
            if (localizationArray == null) return
            for (i in 0 until localizationArray.length()) {
                val jsonObject = localizationArray.optJSONObject(i)
                val strType = jsonObject.optString(JSON_TYPE)
                val content = jsonObject.optJSONArray(strType)
                for (j in 0 until content.length()) {
                    val jsonObjectInner = content.optJSONObject(j)
                    val key = jsonObjectInner.optString(JSON_KEY)
                    val value = jsonObjectInner.optString(JSON_VALUE)

                    val entity = LocalizationEntity(strType, key, value)
                    dao.insert(entity)

                    Log.i(TAG, "strType : " + strType + " -- " + "key : " + key + " -- " + "value : " + value)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}