package com.android.segunfrancis.biometrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_password_manager.*


class PasswordManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_manager)

        val zebra = findViewById<Button>(R.id.SettingsButton)
        zebra.setOnClickListener {
            val intent1 = Intent(this, settings::class.java)
            startActivity(intent1)
        }

        val image = findViewById<ImageButton>(R.id.imageButton69)
        imageButton69.setOnClickListener {
            val intent = Intent(this, password::class.java)
            startActivity(intent)
        }







    }
}