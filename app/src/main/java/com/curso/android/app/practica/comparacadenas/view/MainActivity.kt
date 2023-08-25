package com.curso.android.app.practica.comparacadenas.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.comparacadenas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this) {
            if (it.iguales){
                binding.resultado.text = "Las cadenas son IGUALES"
                } else {
                    binding.resultado.text = "Las cadenas son DISTINTAS"
                }
        }

        binding.boton.setOnClickListener {
            mainViewModel.comparar(binding.texto1.text.toString(),binding.texto2.text.toString())
        }
    }
}