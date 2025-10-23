package com.example.activitat4_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitat4_1.MainActivity.Companion.User_KEY
import com.example.activitat4_1.StartActivity.Companion.Endevinat_KEY
import com.example.activitat4_1.StartActivity.Companion.Number_KEY

class SuccessActivity : AppCompatActivity() {

    var username = ""
    var endevinat = ""
    var endevinar = ""

    private lateinit var usuari: TextView
    private lateinit var numEndevinat: TextView
    private lateinit var numEndevinar: TextView
    private lateinit var btnEnrere: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        username = intent.extras?.getString(User_KEY) ?: "Nom d'usuari"
        endevinar = intent.extras?.getString(Number_KEY) ?: ""
        endevinat = intent.extras?.getString(Endevinat_KEY) ?: ""
        initComponents()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        btnEnrere.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initComponents() {
        usuari = findViewById(R.id.usuari)
        numEndevinat = findViewById(R.id.numEndevinat)
        numEndevinar = findViewById(R.id.numEndevinar)
        btnEnrere = findViewById(R.id.btn_enrere)
    }

    private fun initUI() {
        setUsuari()
        setNums()
    }

    private fun setNums() {
        numEndevinat.text = endevinat
        numEndevinar.text = endevinar
    }

    private fun setUsuari() {
        if (username.isEmpty()){
            username = "Nom d'usuari"
        }
        usuari.text = username
    }
}