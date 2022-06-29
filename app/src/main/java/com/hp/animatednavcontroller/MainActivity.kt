package com.hp.animatednavcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : AnimatedBottomBar
    lateinit var drawerlayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var drawernav:NavigationView
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
        drawerlayout=findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle= ActionBarDrawerToggle(this,drawerlayout, R.string.nav_open, R.string.nav_close)
        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        drawernav=findViewById(R.id.drawer_nav)
        drawernav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_profile ->{
                    fragment = FirstFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.item_setting ->{
                    fragment = SecondFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.item_selfinprovment ->{
                    fragment = ThirdFragment()
                    loadFragment(fragment)
                    true
                }

                else -> {false}
            }
        }


    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.card_space,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item)
    }
}