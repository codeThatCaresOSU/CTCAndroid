package com.example.codethatcaresandroid

import androidx.fragment.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button


class AboutUsFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.about_us_fragment, container, false)
        val b: Button = rootview.findViewById(R.id.get_started_button)
        val mainApp = Intent(context, MainActivity::class.java)
        b.setOnClickListener { startActivity(mainApp) }
        return rootview
    }
}