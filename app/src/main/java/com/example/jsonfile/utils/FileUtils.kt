package com.example.jsonfile.utils

import android.content.Context
import android.content.res.AssetManager
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import com.example.jsonfile.BuildConfig
import com.example.jsonfile.JsonFileApp
import com.example.jsonfile.data.model.MainWords
import com.google.gson.Gson
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

const val WORDS_PATH = "words.json"

object FileUtils {

    fun loadJsonFromAsset(path: String): String? {   // метод считывает байты и созжает String из assets
        var json: String? = null
        try {
            val from = JsonFileApp.applicationContext().assets.open(path)
            val buffer = ByteArray(from.available())
            from.read(buffer)
            from.close()
            json = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

        return json
    }

    fun getWordData(): MainWords {                    // метод обрабатывает String из loadJsonFromAsset и конвертирует в нащ data class
        val json = loadJsonFromAsset(WORDS_PATH)

        val gson = Gson().fromJson(json, MainWords::class.java)
        return gson
    }

    fun loadPfdFromAsset(): Uri {
        val assetManager: AssetManager = JsonFileApp.applicationContext().assets

        var `in`: InputStream? = null
        var out: OutputStream? = null
        val file: File = File(JsonFileApp.applicationContext().filesDir, "abc.pdf")
        val uri = FileProvider.getUriForFile(
            JsonFileApp.applicationContext(),
            BuildConfig.APPLICATION_ID.toString() + ".provider",
            file
        )
        try {
            `in` = assetManager.open("abc.pdf")
            out = JsonFileApp.applicationContext()
                .openFileOutput(file.name, Context.MODE_WORLD_READABLE)
            copyFile(`in`, out)
            `in`.close()
            `in` = null
            out!!.flush()
            out.close()
            out = null
        } catch (e: Exception) {
            Log.e("tag", e.message!!)
        }

        return uri

        Log.d("asdasdasdasd", "adasdasdsadsad")
    }

    private fun copyFile(inputStream: InputStream, outputStream: OutputStream) {
        val buffer = ByteArray(1024)

        var read = 0
        while ((read) != -1) {
            read = inputStream.read(buffer)
            outputStream.write(buffer, 0, read);
        }
    }
}