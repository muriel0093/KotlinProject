package com.example.myapplication

import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
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
            db.insert("APPBANK", null, ContentVal)
            rs.requery()

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Email/Senha")
            ad.setMessage("Email e senha cadastrado com sucesso...!")
            ad.setPositiveButton("ok", DialogInterface.OnClickListener{dialogInterface, i ->
                binding.edName.setText("")
                binding.edSenha.setText("")
                binding.edName.requestFocus()
            })
            ad.show()
        }

    }
}