package com.android.segunfrancis.biometrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.File


class PasswordManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_manager)
        val settingsbutton = findViewById<Button>(R.id.SettingsButton)
        settingsbutton.setOnClickListener {
            val intent = Intent(this, settings::class.java)
            startActivity(intent)









        }
    }
}