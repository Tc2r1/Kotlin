package com.tc2r1.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            tv_box_one,
            tv_box_two,
            tv_box_three,
            tv_box_four,
            tv_box_five,
            constraint_layout,
            btn_red,
            btn_yellow,
            btn_green
        )

        for (view in clickableViews) {
            view.setOnClickListener(this)
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.tv_box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.tv_box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.tv_box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.btn_red -> tv_box_three.setBackgroundResource(R.color.my_red)
            R.id.btn_yellow -> tv_box_four.setBackgroundResource(R.color.my_yellow)
            R.id.btn_green -> tv_box_five.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    override fun onClick(view: View?) {
        view?.let { makeColored(view) }
        Log.wtf("CLICKED", view?.id.toString())
    }

}