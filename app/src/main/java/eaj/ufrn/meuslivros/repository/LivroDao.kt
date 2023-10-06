package eaj.ufrn.meuslivros.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import eaj.ufrn.meuslivros.model.Livro

@Dao
interface LivroDao {

    @Query("SELECT * FROM livros")
    fun listar(): List<Livro>

    @Insert
    fun inserir(livro: Livro)
}