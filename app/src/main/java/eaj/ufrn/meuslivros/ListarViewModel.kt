package eaj.ufrn.meuslivros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eaj.ufrn.meuslivros.model.Livro

class ListarViewModel : ViewModel() {

    private val _livros = MutableLiveData<List<Livro>>()
    val livros: LiveData<List<Livro>>
        get() = _livros

    init {
        _livros.value = emptyList()
    }

    fun setLivros(livros: List<Livro>) {
        _livros.value = livros
    }
}