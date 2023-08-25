package com.curso.android.app.practica.counter.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.counter.model.Comparar
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val comparacion: LiveData<Comparar> get() = _comparacion
    private var _comparacion = MutableLiveData<Comparar>(Comparar(false))

    fun comparar(texto1: String, texto2: String) {
        var next = false
        if (texto1==texto2) {
            next = true
        }
        updater(next)
    }

    private fun updater(next: Boolean) {
        viewModelScope.launch {
            _comparacion.value = Comparar(next)
        }
    }
}
