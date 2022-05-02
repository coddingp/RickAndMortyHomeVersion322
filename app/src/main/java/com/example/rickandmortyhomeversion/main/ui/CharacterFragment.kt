package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.rickandmortyhomeversion.common.basemvp.BaseFragment
import com.example.rickandmortyhomeversion.databinding.CharacterBinding

class CharacterFragment(@LayoutRes layoutRes: Int): BaseFragment(layoutRes) {

    private lateinit var binding: CharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("result") as ResultResponse
        with (binding) {
            context?.let { Glide.with(it).load(data.image).into(characterImageView) }
            textViewName.text = "Name: ${data.name}"
            textViewGender.text = "Gender: ${data.gender}"
            textViewStatus.text = "Status: ${data.status}"
            textViewSpecies.text = "Species: ${data.species}"
        }
    }

    override fun overrideEnterAnimation(animation: Int) {
        TODO("Not yet implemented")
    }

    override fun overrideExitAnimation(animation: Int) {
        TODO("Not yet implemented")
    }
}