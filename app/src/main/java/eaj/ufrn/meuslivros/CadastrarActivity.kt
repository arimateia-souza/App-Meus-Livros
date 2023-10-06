package eaj.ufrn.meuslivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import eaj.ufrn.meuslivros.database.AppDataBase
import eaj.ufrn.meuslivros.databinding.ActivityCadastrarBinding
import eaj.ufrn.meuslivros.model.Livro

class CadastrarActivity : AppCompatActivity() {
    lateinit var binding : ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastrar)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "datbase_meusLivros.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()


        //botão salvar livro
        binding.buttonDoSalvar.setOnClickListener(){
            val nome = binding.editTextTextTitulo.text.toString()
            val autor = binding.editTextTextAutor.text.toString()
            val ano = binding.editTextTextAno.text.toString().toInt()
            val nota = binding.ratingBarNota.rating
            val l = Livro(nome, autor, ano, nota)

            db.livroDao().inserir(l)
            Snackbar.make(it, "O livro foi Salvo!", Snackbar.LENGTH_LONG).show()
            Log.i("Inserçao", "Adicionou no banco: $l ")
        }

        //botão de cancelar
        binding.buttonDoCancelar.setOnClickListener(){
            finish()
        }

    }
}