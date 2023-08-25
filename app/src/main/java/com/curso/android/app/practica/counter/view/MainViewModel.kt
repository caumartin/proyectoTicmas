package com.curso.android.app.practica.counter.view

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.counter.model.Counter
import kotlinx.coroutines.launch
// import org.w3c.dom.Text
// import java.util.Date

class MainViewModel: ViewModel() {

    // Solo queremos que se pueda leer el contador
    val counter: LiveData<Counter> get() = _counter
    // no nos interesa que se modifique por fuera del ViewModel
    private var _counter = MutableLiveData<Counter>(Counter(false))

    fun comparar(texto1: String, texto2: String) {
//        println(texto1)
//        println(texto2)
        var next = false
        if (texto1==texto2) {
            next = true
        }
        updateCounter(next)
    }

    private fun updateCounter(next: Boolean) {
        viewModelScope.launch {
            _counter.value = Counter(next)
        }
    }
}
