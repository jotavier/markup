package br.com.compasso.markup.services.extensions

import java.math.BigDecimal

fun BigDecimal.toCurrency() = if (!this.equals(0)) "R$ ${this.setScale(2)}".replace(".", ",") else "Grátis"