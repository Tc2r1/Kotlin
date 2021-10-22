package com.tc2r1.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_done).setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {
        val editText = findViewById<EditText>(R.id.edit_nickname)
        val nickNameTextView = findViewById<TextView>(R.id.tv_nickname)

        nickNameTextView.text = editText.text

        editText.visibility = View.GONE
        view.visibility = View.GONE

        nickNameTextView.visibility = View.VISIBLE

        // Hide Keyboard when complete.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}