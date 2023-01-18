package com.example.isevwvaleba

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.isevwvaleba.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home_page)
        setContentView(binding.root)
        replaceFragment(saxlifrag())
        binding.navigacia.setOnItemSelectedListener {

            when(it.itemId){
                R.id.saxli -> replaceFragment(saxlifrag())
                R.id.feedback -> replaceFragment(supportfrag())
                R.id.chvenshesaxeb -> replaceFragment(chvenshesaxebfrag())

                else ->{

                }

            }
            true

        }

    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}
