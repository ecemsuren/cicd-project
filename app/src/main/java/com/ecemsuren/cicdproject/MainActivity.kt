package com.ecemsuren.cicdproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ecemsuren.cicdproject.ui.login.LoginScreen
import com.ecemsuren.cicdproject.ui.theme.CiCdProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CiCdProjectTheme {
                LoginScreen(
                    onLoginSuccess = {
                        Toast.makeText(this, "Giriş Başarılı!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
