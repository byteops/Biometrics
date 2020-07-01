package com.android.segunfrancis.biometrics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val executor = Executors.newSingleThreadExecutor()
        val activity: FragmentActivity = this

        val biometricPrompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    activity.runOnUiThread {
                        Toast.makeText(activity, "Canceled ", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Called when an unrecoverable error has been encountered and operation is complete
                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                val intent = Intent(this@MainActivity, PasswordManager::class.java)
                startActivity(intent)
                activity.runOnUiThread {
                    Toast.makeText(activity, "Fingerprint Login Successful", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                activity.runOnUiThread {
                    Toast.makeText(activity, "Fingerprint not Recognized", Toast.LENGTH_SHORT).show()
                }
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Fingerprint Login")
            .setSubtitle("Use fingerprint for easier access")
            .setDescription("Confirm fingerprint to continue")
            .setNegativeButtonText("Cancel")
            .build()

        findViewById<Button>(R.id.authentication_button).setOnClickListener{
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
