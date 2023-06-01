package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityTelaLoginBinding

class Tela_Login : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = DBhelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM APPBANK", null)
        if(rs.moveToFirst()){
            binding.editEmail.setText(rs.getString(1))
            binding.editSenha.setText(rs.getString(2))
        }

        binding.icCadastrar.setOnClickListener{
            val irCadastrarSe = Intent(this, Tela_Cadastro::class.java)
            startActivity(irCadastrarSe)
        }

        binding.icEntrar.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if(senha == "validSenha" && email == "validEmail"){
                val sucefullLogin = Intent(this, MainActivity::class.java)
                startActivity(sucefullLogin)
            }else{
                showMensagem("Email ou senha estao incorretos")
            }
        }
    }
    private fun showMensagem(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}