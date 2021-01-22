package br.com.compasso.markup.ui.fragments.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import br.com.compasso.markup.databinding.FragmentLoadingBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoadingFragment(private val title: String) : DialogFragment() {

    companion object {
        const val TAG = "loading"
    }

    private val binding by lazy { FragmentLoadingBinding.inflate(layoutInflater) }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding.title.text = title
        return MaterialAlertDialogBuilder(requireContext())
            .setView(binding.root)
            .create()
    }
}