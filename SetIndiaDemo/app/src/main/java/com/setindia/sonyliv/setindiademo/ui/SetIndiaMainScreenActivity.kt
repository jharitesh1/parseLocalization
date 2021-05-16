package com.setindia.sonyliv.setindiademo.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.setindia.sonyliv.setindiademo.R
import com.setindia.sonyliv.setindiademo.model.LocalizationEntity
import com.setindia.sonyliv.setindiademo.viewmodel.LocalizationViewModel


class SetIndiaMainScreenActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = SetIndiaMainScreenActivity::class.simpleName
    var locale: String = "en"

    lateinit var localizationViewModel: LocalizationViewModel
    lateinit var btnEnglish: Button
    lateinit var btnHindi: Button
    lateinit var btnChinese: Button
    lateinit var txtHelloWorld: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEnglish = findViewById(R.id.btnEnglish)
        btnHindi = findViewById(R.id.btnHindi)
        btnChinese = findViewById(R.id.btnChina)
        txtHelloWorld = findViewById(R.id.txtHelloWorld)

        btnEnglish.setOnClickListener(this);
        btnHindi.setOnClickListener(this);
        btnChinese.setOnClickListener(this);
        localizationViewModel = ViewModelProviders.of(this).get(LocalizationViewModel::class.java)

        //        localizationViewModel.getAllNotes().observe(this, Observer<List<Any?>?> {
//            -> adapter.submitList(noteEntities)
//        })
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onClick(v: View?) {
        var entity: LocalizationEntity?
        var titleText: String?

        when(v?.id) {
            R.id.btnEnglish -> {
                locale = "en"
            }
            R.id.btnHindi -> {
                locale = "hi"
            }
            R.id.btnChina -> {
                locale = "zh"
            }
        }
        entity = localizationViewModel.getOneEntry(locale, "title")
        titleText = entity?.value

        if(titleText.isNullOrEmpty())
            txtHelloWorld.setText(R.string.title)
        else
            txtHelloWorld.setText(titleText)
    }
}