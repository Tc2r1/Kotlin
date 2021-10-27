package com.nudennie.notepad.util

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.view.View

class SpaceItemDecoration(val context: Context, private val dimenRes: Int) : ItemDecoration() {

    private val space = context.resources.getDimensionPixelOffset(dimenRes)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        when (getOrientation(parent)) {
            LinearLayoutManager.VERTICAL -> if (position != 0) outRect.top = space
            LinearLayoutManager.HORIZONTAL -> if (position != 0) outRect.left = space
        }
    }

    private fun getOrientation(parent: RecyclerView): Int {
        val lm = parent.layoutManager
        return (lm as? LinearLayoutManager)?.orientation ?: -1
    }
}