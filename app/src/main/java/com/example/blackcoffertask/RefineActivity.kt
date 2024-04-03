package com.example.blackcoffertask

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class RefineActivity : AppCompatActivity() {
    private val buttonBgResId = R.drawable.button_bg
    private val buttonBgWhiteResId = R.drawable.button_bg_white
    private lateinit var thumbView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)
        val roles=findViewById<AutoCompleteTextView>(R.id.roles)
        val backBtn=findViewById<ImageView>(R.id.back_icon)
        backBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        // Define the array of values for the spinner
        val rolesArray = arrayOf("Available! Hey Let Us Connect", "Away | Stay Discrete And Watch",
            "Busy! Do Not Disturb", "Away | SOS | Emergency  ! Need Assistence ! Help")

        // Create an ArrayAdapter using the rolesArray
        val adapter = ArrayAdapter(this, R.layout.drop_down_layout2, rolesArray)

        // Set the ArrayAdapter to the AutoCompleteTextView
        roles.setAdapter(adapter)
        val customButton1 = findViewById<AppCompatButton>(R.id.customButton)
        val customButton2 = findViewById<AppCompatButton>(R.id.customButton2)
        val customButton3 = findViewById<AppCompatButton>(R.id.customButton3)
        val customButton4 = findViewById<AppCompatButton>(R.id.customButton4)
        val customButton5 = findViewById<AppCompatButton>(R.id.customButton5)
        val customButton6 = findViewById<AppCompatButton>(R.id.customButton6)
        val customButton7 = findViewById<AppCompatButton>(R.id.customButton7)
        val customButton8 = findViewById<AppCompatButton>(R.id.customButton8)
        thumbView = LayoutInflater.from(this).inflate(R.layout.seekbar_layout, null, false)
        val sk = findViewById<SeekBar>(R.id.seekBar)
        sk.thumb = getThumb(1)

        sk.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                seekBar.thumb = getThumb(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        // Set click listeners for all buttons
        setClickListenerForButton(customButton1)
        setClickListenerForButton(customButton2)
        setClickListenerForButton(customButton3)
        setClickListenerForButton(customButton4)
        setClickListenerForButton(customButton5)
        setClickListenerForButton(customButton6)
        setClickListenerForButton(customButton7)
        setClickListenerForButton(customButton8)
    }

    // Set click listener for the button
    private fun setClickListenerForButton(button: AppCompatButton) {
        button.setOnClickListener {
            // Get the current background drawable
            val currentBackground = button.background

            // Determine the new background drawable
            val newBackground =
                if (currentBackground.constantState?.newDrawable()?.constantState?.equals(
                        resources.getDrawable(buttonBgResId).constantState
                    ) == true
                ) {
                    // Change background to button_bg_white and text color to black
                    button.setTextColor(Color.BLACK)
                    resources.getDrawable(buttonBgWhiteResId)
                } else {
                    // Change background to button_bg and text color to white
                    button.setTextColor(Color.WHITE)
                    resources.getDrawable(buttonBgResId)
                }

            // Set the new background drawable for the button
            button.background = newBackground
        }


    }

    fun getThumb(progress: Int): Drawable? {
        (thumbView.findViewById(R.id.tvProgress) as TextView).text = progress.toString() + ""
        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(
            thumbView.measuredWidth,
            thumbView.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        thumbView.layout(0, 0, thumbView.measuredWidth, thumbView.measuredHeight)
        thumbView.draw(canvas)
        return BitmapDrawable(resources, bitmap)
    }
}
