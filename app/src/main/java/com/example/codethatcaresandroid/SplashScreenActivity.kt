package com.example.codethatcaresandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class SplashScreenActivity : FragmentActivity(){
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = applicationContext?.getSharedPreferences("com.codethatcares.ctcandroid", Context.MODE_PRIVATE)
        if (!prefs!!.getBoolean("splash", true)){
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        setContentView(R.layout.splash_screen_view_container)
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        val ssf: SplashScreenFragment = SplashScreenFragment()
        ft.add(R.id.fragment_container, ssf)
        ft.commit()
    }
}
