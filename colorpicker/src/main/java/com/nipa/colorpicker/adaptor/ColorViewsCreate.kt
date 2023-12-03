package com.nipa.colorpicker.adaptor

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nipa.colorpicker.listner.ColorChoose

internal object ColorViewsCreate {
    fun createRecyclerView(context: Context, constraintLayout: ConstraintLayout, dataList:ArrayList<ColorData>, colorChoose_: ColorChoose, gridColor:Int=4){
        val recyclerView = RecyclerView(context)
        recyclerView.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        recyclerView.id = View.generateViewId()
        constraintLayout.addView(recyclerView)

        val adapter = ColorAdaptor(context,dataList, object : ColorChoose {
            override fun colorSelect(position: Int, data: String) {
                colorChoose_.colorSelect(position,data)

            }
        }) // Replace MyAdapter with your custom adapter
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(context,gridColor)
    }
}