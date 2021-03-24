package com.example.thenewsapp.View

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.thenewsapp.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val bundle: Bundle? = intent.extras
        val url = bundle?.getString("key1")

        val webViewBrowser = findViewById<WebView>(R.id.webview)
        url?.let { webViewBrowser.loadUrl(it) }
    }

}
