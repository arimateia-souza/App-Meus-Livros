package eaj.ufrn.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import eaj.ufrn.meuslivros.database.AppDataBase
import eaj.ufrn.meuslivros.databinding.ActivityCadastrarBinding
import eaj.ufrn.meuslivros.databinding.ActivityListarBinding
import eaj.ufrn.meuslivros.model.Livro
import eaj.ufrn.meuslivros.repository.LivroDao

class ListarActivity : AppCompatActivity() {
    lateinit var binding : ActivityListarBinding
    lateinit var viewModel: ListarViewModel
    lateinit var livrosDao: LivroDao



    var salvos: List<Livro> = listOf()
    var livroAtual = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listar)
        viewModel = ViewModelProvider(this).get(ListarViewModel::class.java)
        binding.lifecycleOwner = this


        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "datbase_meusLivros.sqlite"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries().build()

        livrosDao = db.livroDao()

        salvos = livrosDao.listar()
        viewModel.setLivros(salvos)


        viewModel.livros.observe(this, Observer { listaDeLivros ->
            salvos = listaDeLivros
            exibirLivroAtual()
        })



        binding.buttonAnterior.setOnClickListener {
            if (livroAtual > 0) {
                livroAtual--
                exibirLivroAtual()
                Log.i("Botão Anterior", "passou")
            }
        }

        binding.buttonProximo.setOnClickListener {
            if (livroAtual < salvos.size - 1) {
                livroAtual++
                exibirLivroAtual()
                Log.i("Botão Proximo", "passou pro proximo")
            }
        }

    }
    private fun exibirLivroAtual() {
        if (salvos.isNotEmpty()) {
            val livroAtual = salvos[livroAtual]
            binding.textViewTituloL.text = livroAtual.nome
            binding.textViewAutorL.text = livroAtual.autor
            binding.textViewAnoL.text = livroAtual.ano.toString()
            binding.textViewNotaL.text = livroAtual.nota.toString()
        } else {
            binding.textViewTituloL.text = "teste"
            binding.textViewAutorL.text = ""
            binding.textViewAnoL.text = ""
            binding.textViewNotaL.text = ""
        }

    }
}