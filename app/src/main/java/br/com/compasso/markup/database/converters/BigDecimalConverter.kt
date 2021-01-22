package br.com.compasso.markup.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {
    @TypeConverter
    fun toValue(stringValue: String) = stringValue.toBigDecimal()

    @TypeConverter
    fun toString(value: BigDecimal) = value.toString()
}