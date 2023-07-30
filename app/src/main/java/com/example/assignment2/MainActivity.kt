package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottomNavView)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_barbie -> {
                    switchFragment(BarbieFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_oppenheimer -> {
                    switchFragment(OppenheimerFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        // Initialize the default fragment
        switchFragment(BarbieFragment())
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}