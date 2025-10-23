package com.example.activitat4_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitat4_1.MainActivity.Companion.User_KEY
import kotlin.random.Random

class StartActivity : AppCompatActivity() {

    var username = ""
    val nombre: String = Random.nextInt(1,4).toString()

    private lateinit var usuari: TextView
    private lateinit var numero: EditText
    private lateinit var btnEndevina: Button
    private lateinit var btnEnrere: Button

    companion object{
        const val Number_KEY = "Number"
        const val Endevinat_KEY = "Endevinat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        username = intent.extras?.getString(User_KEY) ?: "Nom d'usuari"
        initComponents()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        btnEndevina.setOnClickListener {
            val endevinat: Boolean = comprobaNombre()
            if (endevinat){
                val intent = Intent(this, SuccessActivity::class.java)
                intent.putExtra(User_KEY, username)
                intent.putExtra(Number_KEY, nombre)
                intent.putExtra(Endevinat_KEY, numero.text.toString())
                startActivity(intent)
            } else {
                val intent = Intent(this, ErrorActivity::class.java)
                intent.putExtra(User_KEY, username)
                intent.putExtra(Number_KEY, nombre)
                intent.putExtra(Endevinat_KEY, numero.text.toString())
                startActivity(intent)
            }
        }
        btnEnrere.setOnClickListener {
            onBackPressed()
        }
    }

    private fun comprobaNombre(): Boolean {
        val nombreEndevinat = numero.text.toString()
        return nombreEndevinat == nombre
    }

    private fun initUI() {
        setUsuari()
    }

    private fun setUsuari() {
        if (username.isEmpty()){
            username = "Nom d'usuari"
        }
        usuari.text = username
    }

    private fun initComponents() {
        usuari = findViewById(R.id.usuari)
        numero = findViewById(R.id.numero)
        btnEndevina = findViewById(R.id.btn_endevina)
        btnEnrere = findViewById(R.id.btn_enrere)
    }
}