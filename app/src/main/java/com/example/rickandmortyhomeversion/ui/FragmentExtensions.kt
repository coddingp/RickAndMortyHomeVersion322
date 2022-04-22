package com.example.rickandmortyhomeversion.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.rickandmortyhomeversion.R

fun Fragment.replaceFragment(fragment: Fragment) {
    val fragmentManager = requireActivity().supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.addToBackStack(null)
        .replace(R.id.fragmentContainer, fragment)
        .commit()
}