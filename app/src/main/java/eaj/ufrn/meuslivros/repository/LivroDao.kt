package eaj.ufrn.meuslivros.repository

import androidx.room.Dao
import androidx.room.Insert
import eaj.ufrn.meuslivros.model.Livro

@Dao
interface LivroDao {

    @Insert
    fun inserir(livro: Livro)
}