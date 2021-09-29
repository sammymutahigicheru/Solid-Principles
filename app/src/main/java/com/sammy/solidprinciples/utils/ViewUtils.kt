package com.sammy.solidprinciples.utils

import android.content.Context
import kotlin.math.roundToInt

object ViewUtils {
    fun convertDpToPixel(context: Context, dp: Int): Int {
        val density = context.applicationContext.resources.displayMetrics.density
        return (dp.toFloat() * density).roundToInt()
    }
}