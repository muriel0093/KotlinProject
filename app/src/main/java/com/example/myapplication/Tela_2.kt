package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityBonusBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityTela2Binding

class Tela_2 : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icVoltar.setOnClickListener{
            val voltarTela1 = Intent(this, MainActivity::class.java)
            startActivity(voltarTela1)
        }
        binding.icDanger.setOnClickListener{
            val telaBonusPika = Intent(this, Bonus::class.java)
            startActivity(telaBonusPika)
        }
    }
}