package com.example.navigationcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.navigationcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.searchFragment),
            binding.drawerLayout
        )

        //Toolbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        //bottom nav bar
        binding.bottomNav.setupWithNavController(navController)

        //navigation drawer
        binding.navDrawer.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (item.itemId == R.id.termsAndConditons) {
//            val action = NavGraphDirections.actionGlobalTermsFragment()
//            navController.navigate(action)
//
//            true
//        }else {
//             item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//        }

        //use "when" instead. Its more flexible to use
        return when(item.itemId) {
            R.id.termsAndConditons -> {
                val action = NavGraphDirections.actionGlobalTermsFragment()
                navController.navigate(action)

                true
            }else -> {
                item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
            }
        }
    }
}