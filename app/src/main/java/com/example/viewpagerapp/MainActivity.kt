package com.example.viewpagerapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerapp.ui.Adapter.NumberAdapter
import com.example.viewpagerapp.ui.Fragments.NotificationFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val NUM_PAGES = 100

@Suppress("DEPRECATION")
class MainActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var addingFloatingActionButton: FloatingActionButton
    private lateinit var removeFloatingActionButton: FloatingActionButton
    private var titlesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)
        addingFloatingActionButton = findViewById(R.id.addFloatingActionButton)
        removeFloatingActionButton = findViewById(R.id.removeFloatingActionButton)

        postToList()
        addingFloatingActionButton.setOnClickListener {
            if(viewPager.currentItem < viewPager.adapter!!.itemCount- 1){
                viewPager.currentItem += 1
            }
        }
        removeFloatingActionButton.setOnClickListener {
            if(viewPager.currentItem > 0){
                viewPager.currentItem -= 1
            }
        }
        viewPager.adapter = NumberAdapter(titlesList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun addToList(title: String){
        titlesList.add(title)
    }
    private fun postToList(){
        for (i in 1..100){
            addToList("$i")
        }
    }
}