package com.github.bilalnasir9.library.ratingbar

import kotlin.math.roundToInt

class RatingTouchHandler {
    fun touchToRating(
        touchX: Float,
        viewWidth: Int,
        maxRating: Int,
        stepSize: Float,
        isRtl: Boolean
    ): Float {
        val totalWidth = viewWidth.toFloat()
        val x = if (isRtl) totalWidth - touchX else touchX
        val fraction = (x / totalWidth) * maxRating
        val stepped = (fraction / stepSize).roundToInt() * stepSize
        return stepped.coerceIn(0f, maxRating.toFloat())
    }
}