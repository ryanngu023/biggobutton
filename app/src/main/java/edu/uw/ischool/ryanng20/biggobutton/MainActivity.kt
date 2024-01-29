package edu.uw.ischool.ryanng20.biggobutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var animationRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        val push: Button = findViewById(R.id.push)

        push.setOnClickListener {
            count++
            onButtonClick(count, push)
        }
    }

    private fun onButtonClick(count: Int, button: Button) {
        var buttonText = getString(R.string.push_count_text, count)
        if (count > 1) {
            buttonText += "s"
        }
        buttonText += "!"
        button.text = buttonText

        val random = Random
        button.setBackgroundColor(Color.rgb(random.nextInt(256),
            random.nextInt(256), random.nextInt(256)))
        button.setTextColor(Color.rgb(random.nextInt(256),
            random.nextInt(256), random.nextInt(256)))

        if (animationRunning) {
            button.clearAnimation()
        } else {
            val fadeIn = AlphaAnimation(0.3f, 1.0f)
            fadeIn.duration = 750
            fadeIn.repeatCount = AlphaAnimation.INFINITE
            button.startAnimation(fadeIn)
        }
        animationRunning = !animationRunning

    }
}