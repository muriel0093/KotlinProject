package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = DBhelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM APPBANK", null)

        //INSERT
        var ContentVal = ContentValues()
        //ContentVal.put("EMAIL", binding.edName.)

        binding.icProximo.setOnClickListener{
            val navegarSegundaTela = Intent(this, Tela_2::class.java)
            startActivity(navegarSegundaTela)
        }
        binding.icLogin.setOnClickListener{
            val logar = Intent(this, Tela_Login::class.java)
            startActivity(logar)
        }
    }
}