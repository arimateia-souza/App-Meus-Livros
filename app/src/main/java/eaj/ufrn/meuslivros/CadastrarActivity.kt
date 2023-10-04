package eaj.ufrn.meuslivros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import eaj.ufrn.meuslivros.databinding.ActivityCadastrarBinding
import eaj.ufrn.meuslivros.databinding.ActivityMainBinding

class CadastrarActivity : AppCompatActivity() {
    lateinit var binding : ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastrar)




        //botão de voltar
        binding.buttonDoCancelar.setOnClickListener(){
            onBackPressed()
        }

    }
}