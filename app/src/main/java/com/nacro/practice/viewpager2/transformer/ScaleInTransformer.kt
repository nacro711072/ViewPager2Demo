package com.nacro.practice.viewpager2.transformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * Nick, 2020/6/17
 *
 */
class ScaleInTransformer(private val scale: Float): ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val scaleValue = (1 - abs(position)) * (1 - scale) + scale
        val pivotX = page.width / 2f * (1 - position)

        page.scaleX = scaleValue
        page.scaleY = scaleValue
        page.pivotX = pivotX
        page.elevation = (1 - abs(position)).coerceAtLeast(0f)
    }

}
