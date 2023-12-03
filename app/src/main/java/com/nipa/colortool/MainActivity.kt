package com.nipa.colortool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nipa.colorpicker.adaptor.ColorData
import com.nipa.colorpicker.databinding.ColorLayoutBinding
import com.nipa.colorpicker.listner.ColorToolsListner
import com.nipa.colortool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , ColorToolsListner {
    val TAG="ColorTool"
    private lateinit var binding:ActivityMainBinding
    private  var colorDataList= ArrayList<ColorData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        colorDataList.add(ColorData("#FF0000"))
        colorDataList.add(ColorData("#000000"))
        colorDataList.add(ColorData("#FFFFFF"))
        colorDataList.add(ColorData("#0000FF"))
        colorDataList.add(ColorData("#008000"))
        colorDataList.add(ColorData("#FFFF00"))
        // Set initial color
        binding.colorLayout.setcolorDataList(colorDataList)


        binding.colorLayout.setOnTextChangedListener(this)

        binding.selectColorButton.setOnClickListener {
         val colorHas=   binding.colorLayout.getColorHasCode()
            val colorInt= binding.colorLayout.getColorIntCode()
            Log.d(TAG,"color code $colorHas - $colorInt")
            Toast.makeText(applicationContext,"seleected color code $colorHas - $colorInt",Toast.LENGTH_LONG).show()
        }
    }

    override fun getColor(colorHas: String, colorInt: Int) {

        Log.d(TAG,"color code $colorHas - $colorInt")
        Toast.makeText(applicationContext,"seleected color code $colorHas - $colorInt",Toast.LENGTH_LONG).show()

    }
}