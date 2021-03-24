package com.example.thenewsapp.Model

data class News(
    val articles: List<Result>
)

data class Result(
    var title: String,
    var urlToImage: String,
    var description: String,
    var url : String
)
