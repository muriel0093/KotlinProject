package com.example.myapplication

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityTelaCadastroBinding

class Tela_Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = DBhelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM APPBANK", null)

        //INSERT
        binding.cadastrar.setOnClickListener{
            var ContentVal = ContentValues()
            ContentVal.put("EMAIL", binding.edName.text.toString())
            ContentVal.put("SENHA", binding.edSenha.text.toString())
            val succeful = db.insert("APPBANK", null, ContentVal)
            if(succeful != -1L){
                Toast.makeText(this, "Cadastro concluido com sucesso", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show()
            }

            rs.requery()
        }

    }
}