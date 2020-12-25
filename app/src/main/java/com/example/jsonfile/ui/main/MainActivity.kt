package com.example.jsonfile.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.jsonfile.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.loadData()
        setupViewModel()
        setupListeners()
    }

    private fun setupListeners() {
        btnClickme.setOnClickListener {
            tvTitle.text = "12345"
        }
    }

    private fun setupViewModel() {
        vm.pdf.observe(this, Observer {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(it, "application/pdf")
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        })
    }
}