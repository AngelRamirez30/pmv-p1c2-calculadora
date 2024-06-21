package com.example.pmv_p1u2_calculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        eventosClick()
    }

    private fun iniciarComponentes() {
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContraseña = findViewById(R.id.txtContraseña)
        btnSalir = findViewById(R.id.btnSalir)
        btnIngresar = findViewById(R.id.btnIngresar)
    }

    private fun eventosClick() {
        btnIngresar.setOnClickListener {
            val usuario: String = getString(R.string.usuario)
            val pass: String = getString(R.string.pass)
            if (txtUsuario.text.toString() == usuario &&
                txtContraseña.text.toString() == pass
            ) {
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("Usuario", getString(R.string.nombre))
                startActivity(intent)
            } else {
                Toast.makeText(
                    this, "Usuario o contraseña no validos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }
}