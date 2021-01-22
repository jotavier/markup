package br.com.compasso.markup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.compasso.markup.databinding.FragmentAccountBinding
import br.com.compasso.markup.services.extensions.toast
import br.com.compasso.markup.ui.viewmodels.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AccountFragment : BaseFragment() {

    private companion object {
        const val DATA_SAVED = "Dados alterados com sucesso"
    }

    private val binding by lazy { FragmentAccountBinding.inflate(layoutInflater) }
    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel.loadAccount()
        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this
        binding.invoke = View.OnClickListener { submit() }
        binding.buttonConfirm.setOnClickListener(binding.invoke)
        return binding.root
    }

    private fun submit() {
        userViewModel.submit().observe(viewLifecycleOwner, { saved ->
            if (saved) {
                toast(DATA_SAVED)
            }
        })
    }
}