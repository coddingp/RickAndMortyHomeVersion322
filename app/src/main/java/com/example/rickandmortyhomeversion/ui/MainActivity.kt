package com.example.rickandmortyhomeversion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.databinding.ActivityMainBinding
import com.example.rickandmortyhomeversion.models.ResultResponse

class MainActivity : AppCompatActivity() {

    lateinit var resultResponse: ResultResponse

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, CharacterListFragment())
            .commit()
    }
}