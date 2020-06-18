package com.nacro.practice.viewpager2

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

/**
 * Nick, 2020/6/17
 *
 */

/**
 * Last line of function {@see ViewPager2#initialize(Context context, AttributeSet attrs)},
 * RecyclerView will be added at 0 index.
 * ( attachViewToParent(mRecyclerView, 0, mRecyclerView.getLayoutParams()) )
 */
fun ViewPager2.getRecyclerView(): RecyclerView = this.getChildAt(0) as RecyclerView

/**
 * Creates a {@link MarginPageTransformer} with integer.
 *
 * Since @link MarginPageTransformer will check whether @param marginPx is non-negative,
 * use reflection to change marginPx to negative if user need it.
 */
fun createMarginPageTransformer(marginPx: Int): MarginPageTransformer {
    return if (marginPx > 0) {
        MarginPageTransformer(marginPx)
    } else {
        MarginPageTransformer(1).apply {
            this::class.java.getDeclaredField("mMarginPx").also { field ->
                field.isAccessible = true
                field.setInt(this, marginPx)
            }
        }
    }
}