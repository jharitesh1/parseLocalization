package com.setindia.sonyliv.setindiademo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.setindia.sonyliv.setindiademo.R
import com.setindia.sonyliv.setindiademo.model.ReadFromFile
import org.json.JSONException
import org.json.JSONObject


class SetIndiaMainScreenActivity : AppCompatActivity() {
    private val TAG = SetIndiaMainScreenActivity::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonFile: String? = ReadFromFile.readFromAssets(this, "set-india-localization.txt");
        Log.i(TAG, "jsonFile : " + jsonFile) ;
        if(!jsonFile.isNullOrEmpty())   parseLocalizationJson(jsonFile)
    }


    private fun parseLocalizationJson(jsonFile: String?) {
        try {
            val obj = JSONObject(jsonFile)
            val localizationArray = obj.optJSONArray("localization")
            if(localizationArray == null) return;
            for (i in 0 until localizationArray.length()) {
                val jsonObject = localizationArray.optJSONObject(i)
                val strType = jsonObject.optString("type")
                val content = jsonObject.optJSONArray(strType)
                for (j in 0 until content.length()) {
                    val jsonObjectInner = content.optJSONObject(j)
                    val key = jsonObjectInner.optString("key")
                    val value =jsonObjectInner.optString("value")

                    Log.i(TAG, "strType : " + strType + " -- " + "key : " + key + " -- " + "value : " + value);
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}