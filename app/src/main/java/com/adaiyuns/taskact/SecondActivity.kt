package com.adaiyuns.taskact

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button


class SecondActivity : BaseActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.change_btn).setOnClickListener {
//
            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
        super.onBackPressed()
    }


}