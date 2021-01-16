package br.com.compasso.findit.services.extensions

import java.math.BigDecimal

fun BigDecimal.toCurrency() = "R$ $this"