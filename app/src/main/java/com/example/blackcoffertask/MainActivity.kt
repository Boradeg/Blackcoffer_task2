package com.example.blackcoffertask
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
<<<<<<< HEAD
import com.google.android.material.bottomnavigation.BottomNavigationView
=======
>>>>>>> 062d9fdc08fa2eb52e0c8a6d9de178468717a66f
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Inside your activity or fragment class
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
// Inside your activity or fragment class
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val refineBtn: TextView = findViewById(R.id.refine_tv)
        val refineImg: ImageView = findViewById(R.id.refineImg)
        // Define the adapter that will return a fragment for each of the two tabs
        val adapter = MyPagerAdapter(supportFragmentManager)
<<<<<<< HEAD
        //tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator_selected)

=======
>>>>>>> 062d9fdc08fa2eb52e0c8a6d9de178468717a66f
        viewPager.adapter = adapter
        refineBtn.setOnClickListener {
            startActivity(Intent(this,RefineActivity::class.java))
        }
        refineImg.setOnClickListener {
            startActivity(Intent(this,RefineActivity::class.java))
        }

        // Setup the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager)
<<<<<<< HEAD
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
=======
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
>>>>>>> 062d9fdc08fa2eb52e0c8a6d9de178468717a66f
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE) // Set both selected and unselected text color to white

        // Optionally, you can give titles to your tabs
        tabLayout.getTabAt(0)?.text = "Personal"
        tabLayout.getTabAt(1)?.text = "Service"
        tabLayout.getTabAt(2)?.text = "Buisness"
<<<<<<< HEAD

=======
>>>>>>> 062d9fdc08fa2eb52e0c8a6d9de178468717a66f
    }

    // Adapter class to provide the appropriate Fragment for each view pager page
    class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> BlankFragment()
                1 -> BlankFragment2()
                2 -> BlankFragment3()
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }

        override fun getCount(): Int {
            // Total number of pages
            return 3
        }
    }


<<<<<<< HEAD

=======
>>>>>>> 062d9fdc08fa2eb52e0c8a6d9de178468717a66f
}
