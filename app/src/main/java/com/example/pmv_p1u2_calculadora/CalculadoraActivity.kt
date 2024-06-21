package com.example.pmv_p1u2_calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var lblUsuario: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var lblResultado: TextView
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var btnRegresar: Button
    private lateinit var btnLimpiar: Button
    private lateinit var calculadora: Calculadora
    private var opcion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes()
        eventosClick()
    }

    private fun iniciarComponentes() {
        lblUsuario = findViewById(R.id.lblUsuario)
        lblResultado = findViewById(R.id.lblResultado)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMult = findViewById(R.id.btnMultiplicar)
        btnDiv = findViewById(R.id.btnDividir)
        btnRegresar = findViewById(R.id.btnRegresar)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        val bundle: Bundle? = intent.extras
        lblUsuario.text = bundle?.getString("Usuario")
    }

    private fun validar(): Boolean {
        return !(txtNum1.text.toString().isEmpty() || txtNum2.text.toString().isEmpty())
    }

    private fun operacion(): Float {
        var res: Float = 0.0f
        if (validar()) {
            val num1 = txtNum1.text.toString().toFloat()
            val num2 = txtNum2.text.toString().toFloat()
            calculadora = Calculadora(num1, num2)
            res = when (opcion) {
                1 -> calculadora.suma()
                2 -> calculadora.resta()
                3 -> calculadora.mult()
                4 -> calculadora.div()
                else -> 0.0f
            }
        } else {
            Toast.makeText(this, "Falto capturar informacion", Toast.LENGTH_SHORT).show()
        }
        return res
    }

    private fun eventosClick() {
        btnSumar.setOnClickListener {
            opcion = 1
            lblResultado.text = operacion().toString()
        }
        btnRestar.setOnClickListener {
            opcion = 2
            lblResultado.text = operacion().toString()
        }
        btnMult.setOnClickListener {
            opcion = 3
            lblResultado.text = operacion().toString()
        }
        btnDiv.setOnClickListener {
            if (txtNum2.text.toString().toFloat() == 0f)
                lblResultado.text = "No es posible dividir sobre 0"
            else {
                opcion = 4
                lblResultado.text = operacion().toString()
            }
        }
        btnLimpiar.setOnClickListener {
            lblResultado.text = ""
            txtNum2.text.clear()
            txtNum1.text.clear()
        }
        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculadora")
            builder.setMessage("¿Desea Cerrar?")
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                this.finish()
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which -> }
            builder.show()
        }
    }
}