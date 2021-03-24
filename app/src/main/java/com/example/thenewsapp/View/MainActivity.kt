package com.example.thenewsapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thenewsapp.R
import com.example.thenewsapp.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getNews()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.movielist.observe(this@MainActivity, {
            val adapter = MyAdapter(this@MainActivity, it)
            recyclerView.adapter = adapter
        })

    }
}