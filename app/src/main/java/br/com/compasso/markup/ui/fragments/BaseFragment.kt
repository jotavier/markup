package br.com.compasso.markup.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.compasso.markup.ui.fragments.dialogs.LoadingFragment
import br.com.compasso.markup.ui.viewmodels.AppViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment : Fragment() {
    protected val controller by lazy { findNavController() }
    protected val app by sharedViewModel<AppViewModel>()
}