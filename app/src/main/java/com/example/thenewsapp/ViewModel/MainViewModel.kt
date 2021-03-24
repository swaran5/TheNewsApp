package com.example.thenewsapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thenewsapp.Model.EndPoints
import com.example.thenewsapp.Model.News
import com.example.thenewsapp.Model.Result
import com.example.thenewsapp.Model.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel() {
    val request = ServiceBuilder.buildService(EndPoints::class.java)
    val key = "0606591d186f4308afcfe1e1a70bc18f"
    var movielist = MutableLiveData<List<Result>>()

    fun getNews() {

            val call = request.getNews( "tesla","2021-02-24","publishedAt",key)

            call.enqueue(object : retrofit2.Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {

                    movielist.postValue(response.body()?.articles)

                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Home Screen", t.toString())
                }

            })
        }
    }
