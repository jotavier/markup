package br.com.compasso.findit.services.extensions

import java.math.BigDecimal

fun BigDecimal.toCurrency() = if (!this.equals(0)) "R$ $this".replace(".", ",") else "Grátis"