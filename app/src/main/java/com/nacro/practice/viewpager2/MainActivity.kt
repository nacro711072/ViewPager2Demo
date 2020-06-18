package com.nacro.practice.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nacro.practice.viewpager2.transformer.ScaleInTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = ViewPager2Adapter(arrayListOf("a", "b", "c"))
        view_pager.offscreenPageLimit = 1 // default is -1
        view_pager.getRecyclerView().apply {
            val padding = resources.getDimension(R.dimen.view_pager_left_and_right_padding).toInt()
            setPadding(padding, 0, padding, 0)
            clipToPadding = false
        }

        CompositePageTransformer().apply {
            addTransformer(createMarginPageTransformer(resources.getDimension(R.dimen.view_pager_margin).toInt()))
            addTransformer(ScaleInTransformer(0.8f))

            view_pager.setPageTransformer(this)
        }

        TabLayoutMediator(tab_layout, view_pager) { tab: TabLayout.Tab, position: Int ->
            tab.text = "tab${position + 1}"
        }.attach()
    }
}
