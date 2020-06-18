package com.nacro.practice.viewpager2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.page_cell.view.*

/**
 * Nick, 2020/6/17
 *
 */
class ViewPager2Adapter(
    private val mData: MutableList<String> = arrayListOf()
): RecyclerView.Adapter<ViewPager2Adapter.Holder>() {

    private val colors: IntArray = intArrayOf(Color.RED, Color.BLUE, Color.YELLOW)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_cell, parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = mData.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.cl_container.setBackgroundColor(colors[position % 3])
        holder.itemView.tv_content.text = mData[position]
    }

    public fun refreshData(data: List<String>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    class Holder(view: View): RecyclerView.ViewHolder(view)
}