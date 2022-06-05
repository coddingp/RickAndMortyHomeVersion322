package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.common.mvvm.BaseActivity
import com.example.rickandmortyhomeversion.databinding.ActivityMainBinding
import com.example.rickandmortyhomeversion.main.models.ResultParced

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            // Create a ViewModel the first time the system calls an activity's onCreate() method.
            // Re-created activities receive the same MyViewModel instance created by the first activity.

            // Use the 'by viewModels()' Kotlin property delegate
            // from the activity-ktx artifact
//            val model: HeroListViewModel by viewModels()
//            model.getCharacters().observe(this) { data ->
                // update UI
                val characterListFragment = CharacterListFragment(R.layout.character)
                replaceFragment(characterListFragment, R.id.fragmentContainer)
//            }

    }
}
