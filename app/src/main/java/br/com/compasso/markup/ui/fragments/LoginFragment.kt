package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.markup.R
import br.com.compasso.markup.databinding.FragmentLoginBinding
import br.com.compasso.markup.services.extensions.delayedNavigate
import br.com.compasso.markup.services.extensions.hideKeyboard
import br.com.compasso.markup.services.extensions.toast
import br.com.compasso.markup.ui.viewmodels.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {
    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this
        binding.buttonConfirm.setOnClickListener(this::submit)
        binding.invoke = View.OnClickListener(this::submit)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        app.showAppBar(false)
        app.showBottomNavigation(false)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun submit(view: View) {
        userViewModel.submit().observe(viewLifecycleOwner, { submit ->
            if (submit) {
                hideKeyboard()
                toast(getString(R.string.label_message_login_success))
                controller.delayedNavigate(LoginFragmentDirections.toHome())
            }
        })
    }
}