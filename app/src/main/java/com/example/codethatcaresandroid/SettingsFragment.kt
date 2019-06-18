package com.example.codethatcaresandroid

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {
    var prefs: SharedPreferences? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.settings_fragment, container, false)
        prefs = context?.getSharedPreferences("com.codethatcares.ctcandroid", Context.MODE_PRIVATE)
        val enableNotifications = rootView.findViewById<SwitchCompat>(R.id.enable_notifications_switch)
        val splashScreen = rootView.findViewById<SwitchCompat>(R.id.splash_switch)
        splashScreen.setOnCheckedChangeListener {_ , isChecked ->
            val editor = prefs?.edit()
            editor?.putBoolean("splash", isChecked)
            editor?.apply()
        }
        enableNotifications.setOnCheckedChangeListener {_ , isChecked ->
            val editor = prefs?.edit()
            editor?.putBoolean("notifications", isChecked)
            editor?.apply()
        }
        enableNotifications.isChecked = prefs!!.getBoolean("notifications" , true)
        splashScreen.isChecked = prefs!!.getBoolean("splash", false)

        return rootView
    }
}