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
//            val entry: Map.Entry<String, Int> = MaterialColor.random(this, "\\D*_500$")
            entries.add(R.drawable.icon_item)
        }
        Log.i("Data","Data===>>>> "+entries.size)

        //populate the adapter, that knows how to draw each item (as you would do with a ListAdapter)
        wheelView.adapter = MaterialColorAdapter(this,entries)

        //a listener for receiving a callback for when the item closest to the selection angle changes
        wheelView.setOnWheelItemSelectedListener { parent, itemDrawable, position -> //get the item at this position
//            val selectedEntry = (parent.adapter as MaterialColorAdapter).getItem(position)
//            parent.setSelectionColor(getContrastColor(selectedEntry))
        }

        wheelView.onWheelItemClickListener =
            OnWheelItemClickListener { parent, position, isSelected ->
                val msg = "$position $isSelected"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }

        //initialise the selection drawable with the first contrast color

        //initialise the selection drawable with the first contrast color
//        wheelView.setSelectionColor(getContrastColor(entries[0]))

        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //wheelView.setSelectionAngle(-wheelView.getAngleForPosition(5));
                wheelView.setMidSelected();
            }
        }, 3000); */
    }

    //get the materials darker contrast
    private fun getContrastColor(entry: Map.Entry<String, Int>): Int {
        val colorName: String = MaterialColor.getColorName(entry)
        return MaterialColor.getContrastColor(colorName)
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