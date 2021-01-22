package br.com.compasso.markup.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.compasso.markup.R
import br.com.compasso.markup.databinding.ActivityMainBinding
import br.com.compasso.markup.ui.viewmodels.AppViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val controller by lazy { findNavController(R.id.main_nav_host_fragment) }
    private val topLevelFragments = setOf(R.id.events, R.id.favorites, R.id.account)
    private val app by viewModel<AppViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Markup)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAppBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setupAppBar() {
        binding.appBar.toolbar.setupWithNavController(controller, AppBarConfiguration(topLevelFragments))
        setupBottomNavigation()
        onDestinationChanged()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(controller)
        binding.bottomNavigation.setOnNavigationItemReselectedListener(null)
    }

    private fun onDestinationChanged() {
        controller.addOnDestinationChangedListener { _, destination, _ ->
            changeIconOf(destination)
            handleComponentsVisibility()
        }
    }

    private fun changeIconOf(
        destination: NavDestination
    ) {
        if (!topLevelFragments.contains(destination.id)) {
            binding.appBar.toolbar.navigationIcon =
                ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back)
        }
    }

    private fun handleComponentsVisibility() {
        appBarVisibility()
        bottomNavigationVisibility()
    }

    private fun bottomNavigationVisibility() {
        app.showBottomNavigation()
        app.bottomNavigationVisibility.observe(this, { visibility ->
            binding.showBottomNavigation = visibility
        })
    }

    private fun appBarVisibility() {
        app.showAppBar()
        app.appBarVisibility.observe(this, { visibility ->
            binding.showAppBar = visibility
        })
    }

    override fun onBackPressed() {
        if (binding.showAppBar == false) {
            return
        }
        super.onBackPressed()
    }
}