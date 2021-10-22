package com.tc2r1.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tc2r1.aboutme.data.MyName
import com.tc2r1.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Nudennie White")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Without Data Binding
        //setContentView(R.layout.activity_main)
        //        findViewById<Button>(R.id.btn_done).setOnClickListener {
        //            addNickName(it)
        //        }


        // With Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.apply {

            btnDone.setOnClickListener {
                addNickName(it)
            }
        }
    }

    private fun addNickName(view: View) {

        binding.apply {
            myName?.nickName = etNickname.text.toString()
            invalidateAll()
            etNickname.visibility = View.GONE
            btnDone.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }
        // Hide Keyboard when complete.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}