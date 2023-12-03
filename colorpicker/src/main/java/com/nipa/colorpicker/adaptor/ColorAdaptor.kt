package com.nipa.colorpicker.adaptor

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nipa.colorpicker.R

import com.nipa.colorpicker.listner.ColorChoose

internal class ColorAdaptor(private val context: Context, private var dataList_: List<ColorData>, private val colorChoose_: ColorChoose): RecyclerView.Adapter<ColorAdaptor.MyViewHolder>() {

        class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            var cvColor: CardView
            var tvName: TextView
            init{
                cvColor=itemView.findViewById(R.id.cvColor)
                tvName=itemView.findViewById(R.id.tvName)

            }
        }

        private  var dataList= dataList_
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.adaptor_color_layout, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.cvColor.setCardBackgroundColor(Color.parseColor(dataList.get(position).hasCode))
            holder.tvName.setText(dataList.get(position).name)
            holder.cvColor.setOnClickListener {
                if(colorChoose_!=null){
                    colorChoose_.colorSelect(position,dataList.get(position).hasCode)
                }
            }

        }

    }
