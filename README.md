# Color Picker Tools for Android

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## Demo

[![Color Picker Demo](https://img.youtube.com/vi/RM-g4pa--5E/0.jpg)](https://www.youtube.com/shorts/RM-g4pa--5E)

## Description

Color Picker Tools is an Android library written in Kotlin that provides a customizable color picker widget. This library allows you to easily integrate a color picker into your Android app, enabling users to select colors from a predefined palette.

## Usage

To integrate the Color Picker Tools into your Android project, follow these steps:

1. Add the `ColorLayout` widget to your XML layout file:

    ```xml
    <com.nipa.colorpicker.ColorLayout
        android:id="@+id/colorLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"/>
    ```

2. In your main activity, initialize the color palette and set the initial color:

    ```kotlin
    // Initialize ColorData list
    private var colorDataList = ArrayList<ColorData>()

    // Add colors to the palette
    colorDataList.add(ColorData("#FF0000"))
    colorDataList.add(ColorData("#000000"))
    colorDataList.add(ColorData("#FFFFFF"))
    colorDataList.add(ColorData("#0000FF"))
    colorDataList.add(ColorData("#008000"))
    colorDataList.add(ColorData("#FFFF00"))

    // Set initial color
    binding.colorLayout.setcolorDataList(colorDataList)
    ```

3. Set up a listener for text changes and handle color selection:

    ```kotlin
    // Set text change listener
    binding.colorLayout.setOnTextChangedListener(this)

    // Handle color selection
    binding.selectColorButton.setOnClickListener {
        val colorHas = binding.colorLayout.getColorHasCode()
        val colorInt = binding.colorLayout.getColorIntCode()
        Log.d(TAG, "Selected color code: $colorHas - $colorInt")
        Toast.makeText(applicationContext, "Selected color code: $colorHas - $colorInt", Toast.LENGTH_LONG).show()
    }
    ```
You can  customize color by changing progress bar and create new color code

