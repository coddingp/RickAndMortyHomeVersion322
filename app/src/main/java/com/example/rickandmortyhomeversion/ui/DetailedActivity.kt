package com.example.rickandmortyhomeversion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rickandmortyhomeversion.databinding.ActivityDetailedBinding
import com.example.rickandmortyhomeversion.models.ResultResponse


class DetailedActivity : AppCompatActivity() {

    private val binding: ActivityDetailedBinding by lazy {
        ActivityDetailedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResultResponse>("result")

        with(binding) {
            Glide.with(this@DetailedActivity).load(data?.image).into(characterImageView)
            textViewName.text = "Name: ${data?.name}"
            textViewGender.text = "Gender: ${data?.gender}"
            textViewStatus.text = "Status: ${data?.status}"
            textViewSpecies.text = "Species: ${data?.species}"
        }
    }
}