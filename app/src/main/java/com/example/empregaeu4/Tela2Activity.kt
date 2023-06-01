package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empregaeu4.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnext = binding.bttnext
        val btnext2 = binding.button2
        val btnext3 = binding.button3

        btnext.setOnClickListener{
            val intenn = Intent(this, NextpageActivity::class.java)
            startActivity(intenn)
        }
        btnext2.setOnClickListener{
            val intent = Intent(this, NextpageActivity::class.java)
            startActivity(intent)
        }
        btnext3.setOnClickListener{
            val inten = Intent(this, MainActivity2::class.java)
            startActivity(inten)
        }
    }
}