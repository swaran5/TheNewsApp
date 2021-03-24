package com.example.thenewsapp.View

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.thenewsapp.Model.Result
import com.example.thenewsapp.R
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val result: List<Result>) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MyHolder(view)

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val article = result[position]
        holder.setData(article)
    }

    override fun getItemCount(): Int {
        return result.size
    }
    
    inner class MyHolder(val v: View) : RecyclerView.ViewHolder(v) {
        var url = ""

        init {
            v.setOnClickListener {
                val intent = Intent(context, SecondActivity::class.java)
                intent.action = Intent.ACTION_SEND
                intent.putExtra("key1", url)
                startActivity(context, intent, null)

            }
        }

        fun setData(obj: Result) {

            val imageurl = obj.urlToImage
            Picasso.get().load(imageurl).into(v.findViewById<ImageView>(R.id.imageView))

            v.findViewById<TextView>(R.id.title).text = obj.title

            v.findViewById<TextView>(R.id.description).text = obj.description

            url = obj.url

        }
    }
}