package com.example.android.secureme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.secureme.database.CentroDeTrabajoDatabase
import com.example.android.secureme.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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

        val tabLayout = binding.tabLayout
        val pager = binding.pager

        pager.adapter = LocateAdapter(this)

        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> tab.text = "Consulta"
                1 -> tab.text = "Mapa"
            }
        }.attach()

        binding.setLifecycleOwner(this)
    }
}