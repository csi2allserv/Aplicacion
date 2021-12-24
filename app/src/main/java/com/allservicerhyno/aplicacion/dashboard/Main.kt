package com.allservicerhyno.aplicacion.dashboard

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.allservicerhyno.aplicacion.R
import com.allservicerhyno.aplicacion.dashboard.Home

class Main : AppCompatActivity() {

    lateinit var  home :Home
    lateinit var account: Account
    lateinit var settings: Settings
    lateinit var notification: Notification

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomBar)
        val frame = findViewById<FrameLayout>(R.id.frame)
        //Default Fragment
        home = Home()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame,home)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    home = Home()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,home)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.account -> {
                    account = Account()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,account)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.settings -> {
                    settings = Settings()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,settings)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.notification -> {
                    notification = Notification()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame,notification)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }

    private fun replace(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}