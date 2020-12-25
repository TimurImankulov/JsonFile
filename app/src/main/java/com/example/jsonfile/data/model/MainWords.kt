package com.example.jsonfile.data.model

import com.google.gson.annotations.SerializedName

data class MainWords(
    @SerializedName("words") val words: List<Words>
)