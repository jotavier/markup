package br.com.compasso.markup.services.extensions

import android.os.Handler
import android.os.Looper
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import br.com.compasso.markup.services.TimeConstants


fun NavController.delayedNavigate(
    direction: NavDirections,
    timeInMillis: Long = TimeConstants.ONE_SECOND
) {
    Handler(Looper.getMainLooper()).postDelayed({
        this.navigate(direction)
    }, timeInMillis)
}