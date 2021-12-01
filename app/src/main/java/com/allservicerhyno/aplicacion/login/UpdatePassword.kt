package com.allservicerhyno.aplicacion.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.allservicerhyno.aplicacion.databinding.UpdatePasswordBinding
import com.allservicerhyno.aplicacion.room.App
import com.allservicerhyno.aplicacion.room.Persona
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UpdatePassword : AppCompatActivity() {
    
    private lateinit var binding: UpdatePasswordBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdatePasswordBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        
        //Restore password
        binding.actualizar.setOnClickListener {
            
            if (binding.Email.text.isNotEmpty() && binding.Password.text.isNotEmpty()) {
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        
                        val updateUser = Persona(
                            0,
                            binding.Email.text.toString(),
                            binding.Password.text.toString()
                        )
                        App.getDb().personaDao().update(updateUser)
                    }
                    
                }
                val lanzar = Intent(this@UpdatePassword, Login::class.java)
                startActivity(lanzar)
            } else {
                Toast.makeText(
                    this@UpdatePassword,
                    "Error al Actualizar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        
    }
    
}