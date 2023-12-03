package com.nipa.colorpicker

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.nipa.colorpicker.adaptor.ColorData
import com.nipa.colorpicker.adaptor.ColorViewsCreate.createRecyclerView
import com.nipa.colorpicker.databinding.ColorLayoutBinding

import com.nipa.colorpicker.listner.ColorChoose
import com.nipa.colorpicker.listner.ColorToolsListner

class ColorLayout:ConstraintLayout {
    var contextView:Context
    lateinit var binding: ColorLayoutBinding
    private  var colorDataList= ArrayList<ColorData>()
    var colorToolsListner: ColorToolsListner?=null
    var colerSelected=""
    var colorInt:Int=0
    constructor(context: Context) : super(context) {
        this.contextView=context
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.contextView=context
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.contextView=context
        init(attrs)
    }
    fun init(attrs: AttributeSet?){

         binding = ColorLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        setSeekbar()

    }
    fun setSeekbar(){
        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setColorPreview()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        }
        binding.alphaSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
        binding.redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
        binding.greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
        binding.blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener)
    }
    fun setcolorDataList(_colorDataList:ArrayList<ColorData>){
        this.colorDataList=_colorDataList
        adaptorCall()
    }

    private fun setColorPreview() {
        val alpha = maxOf(binding.alphaSeekBar.progress, 4)
        val color = Color.argb(
            alpha,
            binding.redSeekBar.progress,
            binding.greenSeekBar.progress,
            binding.blueSeekBar.progress
        )
        colerSelected=String.format("#%06X", 0xFFFFFF and color)
        colorInt=color
        binding.colorPreview.setBackgroundColor(color)
        binding.textColor.text=String.format(colerSelected)
        // set data to on listner
        colorToolsListner?.getColor(colerSelected,color)
    }
    fun adaptorCall(){
        createRecyclerView(contextView,binding.cvColorPalet,colorDataList, object : ColorChoose {
            override fun colorSelect(position: Int, data: String) {
                colerSelected=data
                val redDrawable = ColorDrawable(Color.parseColor(colorDataList.get(position).hasCode))
                binding.colorPreview.background=redDrawable
                binding.textColor.text=colorDataList.get(position).hasCode

                // // Convert hex color to Color
                val colorInt = Color.parseColor(colerSelected)
                val alpha = Color.alpha(colorInt)
                val red = Color.red(colorInt)
                val green = Color.green(colorInt)
                val blue = Color.blue(colorInt)
                // Set progress of SeekBars
                binding.alphaSeekBar.progress = alpha
                binding.redSeekBar.progress = red
                binding.greenSeekBar.progress = green
                binding.blueSeekBar.progress = blue
            }
        })
    }
    fun getColorIntCode():Int{
        return colorInt
    }
    fun getColorHasCode():String{
        return colerSelected;
    }
    fun setOnTextChangedListener(listener: ColorToolsListner) {
        colorToolsListner = listener
    }
}