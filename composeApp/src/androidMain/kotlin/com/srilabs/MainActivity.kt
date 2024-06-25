package com.srilabs

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() { // ComponentActivity() {

    companion object {
        lateinit var appContext: Context
            private set
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContext = applicationContext
        try {
            setContent {
                App()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}