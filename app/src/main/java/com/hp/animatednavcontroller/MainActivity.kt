package com.hp.animatednavcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : AnimatedBottomBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(FirstFragment())
        bottomNav=findViewById(R.id.bottom_bar)
        var fragment:Fragment
        bottomNav.apply {
            onTabSelected = {

             when(it.id){
                                 R.id.it_firstitem -> {
                    fragment = FirstFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.it_seconditem -> {
                    fragment = SecondFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.it_thirditem -> {
                    fragment = ThirdFragment()
                    loadFragment(fragment)
                    true

                }
             }

            }

        }

//        bottomNav.onTabReselected { item->
//            var fragment:Fragment
//            when (item.itemId) {
//                R.id.it_firstitem -> {
//                    fragment = FirstFragment()
//                    loadFragment(fragment)
//                    true
//                }
//                R.id.it_seconditem -> {
//                    fragment = SecondFragment()
//                    loadFragment(fragment)
//                    true
//
//                }
//                R.id.it_thirditem -> {
//                    fragment = ThirdFragment()
//                    loadFragment(fragment)
//                    true
//
//                }
//
//                else -> false
//            }
//        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.card_space,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}