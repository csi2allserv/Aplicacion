package com.allservicerhyno.aplicacion.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.allservicerhyno.aplicacion.R
import com.allservicerhyno.aplicacion.databinding.LoginpreviewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Loginpreview : AppCompatActivity() {
    
    
    lateinit var binding: LoginpreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginpreviewBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        supportActionBar?.hide()

        CoroutineScope(Dispatchers.Main).launch {
            delay(6000L)
            startActivity(Intent(this@Loginpreview, Login::class.java))
            finish()
        }
    }
}