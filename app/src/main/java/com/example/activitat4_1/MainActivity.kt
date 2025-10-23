package com.example.activitat4_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var data: TextView
    private lateinit var usuari: EditText
    private lateinit var boton: Button

    companion object{
        const val User_KEY = "User"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setData()
    }

    @SuppressLint("NewApi")
    private fun setData() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatted = current.format(formatter)
        data.text = formatted
    }

    private fun initComponents() {
        data = findViewById(R.id.data)
        usuari = findViewById(R.id.usuari)
        boton = findViewById(R.id.boton)
    }

    private fun initListeners() {
        boton.setOnClickListener {
            val username = usuari.text.toString()
            navigateToStart(username)
        }
    }

    private fun navigateToStart(username: String) {
        val intent = Intent(this, StartActivity::class.java)
        intent.putExtra(User_KEY, username)
        startActivity(intent)
    }
}