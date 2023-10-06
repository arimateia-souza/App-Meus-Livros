package eaj.ufrn.meuslivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import eaj.ufrn.meuslivros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Botão Cadastrar
        binding.buttonCadastrar.setOnClickListener(){
            var intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }
        //Botão Listar
        binding.buttonListar.setOnClickListener(){
            var intent = Intent(this, ListarActivity::class.java)
            startActivity(intent)
        }

    }
}