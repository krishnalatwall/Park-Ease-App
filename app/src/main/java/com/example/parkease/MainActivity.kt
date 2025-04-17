package com.example.parkease

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var topAppBar: MaterialToolbar
    private lateinit var mainContent: FrameLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        topAppBar = findViewById(R.id.topAppBar)
        mainContent = findViewById(R.id.mainContent)

        // Hamburger icon opens drawer
        topAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handle menu item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_dashboard -> {
                    // Replace main content with Dashboard Fragment or View
                    val dashboardFragment = DashboardFragment()  // Create fragment or view
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContent, dashboardFragment)
                        .commit()
                }
                R.id.nav_settings -> {
                    // Start Settings Activity
                    startActivity(Intent(this, SettingsActivity::class.java))
                }
                R.id.nav_logout -> {
                    // Handle logout logic here
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()  // Close the current activity
                }
                // You can add more items here as needed
            }
            // Close the navigation drawer after an item is selected
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Load default content (Dashboard Fragment or any initial content)
        val dashboardFragment = DashboardFragment()  // Replace with your fragment or view
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContent, dashboardFragment)
            .commit()
    }
}
