package br.com.compasso.markup.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.compasso.markup.R
import br.com.compasso.markup.databinding.ActivityEventBinding
import br.com.compasso.markup.http.repositories.Resource
import br.com.compasso.markup.services.extensions.toast
import br.com.compasso.markup.ui.viewmodels.EventViewModel
import org.koin.android.ext.android.inject

class EventActivity : BaseActivity() {

    private val controller by lazy { findNavController(R.id.event_nav_host_fragment) }
    private val binding by lazy { ActivityEventBinding.inflate(layoutInflater) }
    private val args by navArgs<EventActivityArgs>()
    private val eventViewModel by inject<EventViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupActionBar()
        loadEvent()
    }

    private fun loadEvent() {
        eventViewModel.mEvent = args.event
    }

    private fun configureCheckInButton() {
        binding.checkInButton.setOnClickListener(this::checkIn)
    }

    private fun setupActionBar() {
        val builder = AppBarConfiguration.Builder()
        builder.setFallbackOnNavigateUpListener {
            finish()
            true
        }
        setSupportActionBar(binding.appBar.toolbar)
        binding.appBar.toolbar.setupWithNavController(controller, builder.build())
        onDestinationChanged()
        setupBottomNavigation()
        configureCheckInButton()
    }

    private fun onDestinationChanged() {
        controller.addOnDestinationChangedListener { _, _, _ ->
            binding.appBar.toolbar.navigationIcon = ContextCompat.getDrawable(
                this,
                R.drawable.ic_back
            )
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun checkIn(view: View) {
        eventViewModel.checkIn()?.observe(this, { res ->
            res.message?.let { toast(view, it) }
            when (res.status) {
                Resource.Status.SUCCESS -> stopLoading()
                Resource.Status.FAILURE -> stopLoading()
                Resource.Status.LOADING -> startLoading()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.event_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> eventViewModel.share(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp()
                || super.onSupportNavigateUp()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(controller)
    }
}