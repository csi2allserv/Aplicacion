package com.allservicerhyno.aplicacion.dashboard

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.allservicerhyno.aplicacion.R
import com.allservicerhyno.aplicacion.dashboard.Home

class Main : AppCompatActivity() {
    private var bottomBar: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        replace(Home())
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replace(Home())
                R.id.account -> replace(Account())
                R.id.settings -> replace(Settings())
                R.id.notifitication -> replace(Notification())
            }
            true
        })
    }

    private fun replace(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}