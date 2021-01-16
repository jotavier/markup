package br.com.compasso.findit.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.compasso.findit.ui.viewmodels.AppBarViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment : Fragment() {
    protected val controller by lazy { findNavController() }
    protected val appBar by sharedViewModel<AppBarViewModel>()
}