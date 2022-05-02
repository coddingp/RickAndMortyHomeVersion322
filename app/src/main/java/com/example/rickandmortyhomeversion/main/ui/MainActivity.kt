package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.common.basemvp.BaseActivity
import com.example.rickandmortyhomeversion.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val characterListFragment = CharacterListFragment()
        changeFragment(characterListFragment, R.id.fragmentContainer)
    }

}