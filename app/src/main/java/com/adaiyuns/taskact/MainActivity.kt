package com.adaiyuns.taskact

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.adaiyuns.wheelcircle.adapter.WheelArrayAdapter
import com.adaiyuns.wheelcircle.WheelView
import com.adaiyuns.wheelcircle.WheelView.OnWheelItemClickListener


class MainActivity : AppCompatActivity() {

    private lateinit var wheelView: WheelView
    private val ITEM_COUNT = 5

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wheelView = findViewById(R.id.wheelview)
        init()
    }

    private fun init(){
        val entries: MutableList<Int> = ArrayList(ITEM_COUNT)
        for (i in 0 until ITEM_COUNT) {
            entries.add(R.drawable.planet)
        }
        wheelView.adapter = MaterialColorAdapter(this,entries)

        wheelView.setOnWheelItemSelectedListener { parent, itemDrawable, position -> //get the item at this position

        }

        wheelView.onWheelItemClickListener =
            OnWheelItemClickListener { parent, position, isSelected ->
                val msg = "$position $isSelected"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
    internal class MaterialColorAdapter(context: Context,entries: List<Int>) : WheelArrayAdapter<Int>(entries) {
        private val contextImpl = context
        override fun getDrawable(position: Int): Drawable {
            return ContextCompat.getDrawable(contextImpl,getItem(position))!!
        }
    }
}