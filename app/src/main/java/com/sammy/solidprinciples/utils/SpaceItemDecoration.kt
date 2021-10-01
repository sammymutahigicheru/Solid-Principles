package com.sammy.solidprinciples.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

internal class SpaceItemDecoration(var spaceInPx: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = spaceInPx
        outRect.right = spaceInPx
        outRect.bottom = spaceInPx

        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1) {
            outRect.top = spaceInPx;
        } else {
            outRect.top = 0;
        }
    }

}