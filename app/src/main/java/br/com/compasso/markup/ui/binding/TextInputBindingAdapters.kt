package br.com.compasso.markup.ui.binding

import android.os.Handler
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.BindingAdapter
import br.com.compasso.markup.services.TimeConstants
import br.com.compasso.markup.services.extensions.hideKeyboard
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:error")
fun error(inputLayout: TextInputLayout, error: String?) {
    inputLayout.error = error
    Handler(inputLayout.context.mainLooper).postDelayed(
        { inputLayout.error = null },
        2 * TimeConstants.ONE_SECOND
    )
}

@BindingAdapter("app:onDone")
fun onDone(editText: EditText, onClickListener: View.OnClickListener) {
    editText.setOnEditorActionListener { _, actionId, _ ->
        when (actionId) {
            EditorInfo.IME_ACTION_DONE -> {
                editText.hideKeyboard()
                Handler(editText.context.mainLooper).postDelayed(
                    { onClickListener.onClick(editText) },
                    TimeConstants.HALF_SECOND
                )
                true
            }
            else -> false
        }
    }
}