package com.example.rickandmortyhomeversion.common.mvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

abstract class BaseActivity : AppCompatActivity() {

    protected fun replaceFragment(fragment: Fragment, id: Int) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(id, fragment)
            .commit()
    }

    protected fun toBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 1) {
            val firstFragment = manager.getBackStackEntryAt(0)
            manager.popBackStack(firstFragment.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}