package com.github.bilalnasir9.library.ratingbar

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.github.bilalnasir9.library.R

class CustomRatingBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs)  {


     var rating: Float = 0f
        set(value) { field = value; invalidate() }

    var maxRating: Int = 5
        set(value) { field = value; invalidate() }

    var stepSize: Float = 1f
        set(value) { field = value; invalidate() }

    var isReadOnly: Boolean = false
        set(value) { field = value; isClickable = !value }

    private val drawableHelper = RatingDrawableHelper(context, attrs)
    private val touchHandler   = RatingTouchHandler()

    var setOnRatingBarChangeListener: ((Float, Boolean) -> Unit)? = null


    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomRatingBar, 0, 0).apply {
            try {
                maxRating   = getInt(R.styleable.CustomRatingBar_maxRating, 5)
                rating      = getFloat(R.styleable.CustomRatingBar_rating, 0f)
                stepSize    = getFloat(R.styleable.CustomRatingBar_stepSize, 1f)
                isReadOnly = getBoolean(R.styleable.CustomRatingBar_readOnly, false)
            } finally {
                recycle()
            }
        }

        isClickable = !isReadOnly
        isFocusable = true
    }

    fun setIcons(
        filled: Int=R.drawable.ic_star_crb_filled,
        empty: Int=R.drawable.ic_star_crb_empty,
        half: Int = R.drawable.ic_star_crb_half
    ) {
        drawableHelper.setIcons(filled, empty, half)
        invalidate()
    }
    override fun onMeasure(w: Int, h: Int) {
        val width = paddingLeft + paddingRight + drawableHelper.totalWidth(maxRating)
        val height = paddingTop + paddingBottom + drawableHelper.iconSize
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        drawableHelper.drawRating(canvas, rating, maxRating, paddingLeft, paddingTop, isRtl())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (isReadOnly) return false

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                val newRating = touchHandler.touchToRating(event.x, width, maxRating, stepSize, isRtl())
                if (newRating != rating) {
                    rating = newRating
                    setOnRatingBarChangeListener?.invoke(rating, true)
                }
                if (event.actionMasked == MotionEvent.ACTION_UP) performClick()
            }
        }
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
    private fun isRtl(): Boolean =
        layoutDirection == LAYOUT_DIRECTION_RTL

}