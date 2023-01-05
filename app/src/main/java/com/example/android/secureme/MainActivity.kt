package com.example.android.secureme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.secureme.database.CentroDeTrabajoDatabase
import com.example.android.secureme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dataSource = CentroDeTrabajoDatabase.getInstance(application).centroDeTrabajoDatabaseDao

        val viewModelFactory = MainViewModelFactory(dataSource)

        viewModel =
            ViewModelProvider(
                this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)
    }
}