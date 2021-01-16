package br.com.compasso.findit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import br.com.compasso.findit.R
import br.com.compasso.findit.databinding.ActivityMainBinding
import br.com.compasso.findit.ui.viewmodels.AppBarViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val controller by lazy { findNavController(R.id.nav_host_fragment) }
    private val appBar by viewModel<AppBarViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configureAppBar()
    }

    private fun configureAppBar() {
        controller.addOnDestinationChangedListener { _, _, _ ->
            appBar.show()
            appBar.visibility.observe(this, { visibility ->
                binding.showAppBar = visibility
            })
        }
    }
}