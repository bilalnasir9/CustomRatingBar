package com.github.bilalnasir9.library.ratingbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.github.bilalnasir9.library.R

class RatingDrawableHelper(private val context: Context, attrs: AttributeSet?) {
    val iconSize: Int
    private val iconPadding: Int
    private var filledDrawable: Drawable
    private var halfDrawable: Drawable
    private var emptyDrawable: Drawable

    private val defaultFilled = R.drawable.ic_star_crb_filled
    private val defaultHalf   = R.drawable.ic_star_crb_half
    private val defaultEmpty  = R.drawable.ic_star_crb_empty

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomRatingBar)
        iconSize = a.getDimensionPixelSize(R.styleable.CustomRatingBar_iconSize, 48)
        iconPadding = a.getDimensionPixelSize(R.styleable.CustomRatingBar_iconPadding, 0)
        val filled = a.getResourceId(R.styleable.CustomRatingBar_iconFilled, defaultFilled)
        val half = a.getResourceId(R.styleable.CustomRatingBar_iconHalf, defaultHalf)
        val empty = a.getResourceId(R.styleable.CustomRatingBar_iconEmpty, defaultEmpty)
        a.recycle()

        filledDrawable = wrapDrawable(context, filled)
        emptyDrawable = wrapDrawable(context, empty)
        halfDrawable = wrapDrawable(context, half)
    }
    fun setIcons(filled: Int, empty: Int, half: Int) {
        filledDrawable = wrapDrawable(context, filled)
        emptyDrawable = wrapDrawable(context, empty)
        halfDrawable = wrapDrawable(context, half)
    }


    private fun wrapDrawable(context: Context, resId: Int): Drawable =
        DrawableCompat.wrap(ContextCompat.getDrawable(context, resId)!!.mutate())

    fun drawRating(
        canvas: Canvas,
        rating: Float,
        max: Int,
        startX: Int,
        startY: Int,
        rtl: Boolean
    ) {
        var x = if (rtl) canvas.width - startX - iconSize else startX

        for (i in 0 until max) {
            val drawable = when {
                rating >= i + 1f -> filledDrawable
                rating >= i + 0.5f -> halfDrawable
                else -> emptyDrawable
            }

            drawable.setBounds(x, startY, x + iconSize, startY + iconSize)
            drawable.draw(canvas)

            x = if (rtl) x - (iconSize + iconPadding)
            else x + (iconSize + iconPadding)
        }
    }

    fun totalWidth(count: Int): Int =
        count * (iconSize + iconPadding) - iconPadding
}