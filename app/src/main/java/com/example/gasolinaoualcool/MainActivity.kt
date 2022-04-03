package com.example.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else{
            textResultado.text = "Preencha os campos primerio!"
        }
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool/valorGasolina

        if( resultadoPreco >= 0.7 ){
            textResultado.text = "Melhor utilizar Gasolina!"
        }else{
            textResultado.text = "Melhor utilizar Álcool!"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean {
            var camposValidados: Boolean = true
            if (precoAlcool == null || precoAlcool.equals("") ){
                camposValidados = false
            }else if(precoGasolina == null || precoGasolina.equals("") ){
                camposValidados = false
            }
        return camposValidados
    }
}