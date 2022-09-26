package com.latihan.latihanonlineoffline.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.latihanonlineoffline.core.data.Resource
import com.latihan.latihanonlineoffline.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvFact.layoutManager = LinearLayoutManager(this)
        binding.rvFact.setHasFixedSize(true)
        mainViewModel.factList.observe(this) {
            when(it) {
                is Resource.Success -> {
                    binding.rvFact.adapter = FactAdapter(it.data ?: mutableListOf())
                }
                is Resource.Loading -> {
                    Log.d("MainActivity", "onCreate: loading")
                }
                is Resource.Error -> {
                    Log.e("MainActivity", "Error: ${it.message}")
                }
            }
        }
    }
}