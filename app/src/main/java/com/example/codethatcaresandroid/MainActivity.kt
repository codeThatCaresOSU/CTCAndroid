package com.example.codethatcaresandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView

const val NUM_ITEMS = 2

class MainActivity : AppCompatActivity() {
    lateinit var mPager: ViewPager
    lateinit var mAdapter: MyAdapter
    lateinit var bubView: BubbleNavigationConstraintView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        mAdapter = MyAdapter(supportFragmentManager)
        mPager = findViewById(R.id.pager_view)
        mPager.adapter = mAdapter
        bubView = findViewById(R.id.top_navigation_constraint)

        //these link the bubbleview and the view pager together
        bubView.setNavigationChangeListener {view, position ->
            mPager.currentItem = position
        }
        mPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageSelected(position: Int){
                bubView.setCurrentActiveItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
        })
    }

    class MyAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        override fun getCount(): Int {
            return NUM_ITEMS
        }

        override fun getItem(position: Int): Fragment {
            val fragment: Fragment
            when (position){
                0 -> fragment = ListViewFragment()
                else -> fragment = SettingsFragment()
            }
            return fragment
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importantance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(FirebaseMessagingService.CHANNEL_ID, name, importantance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
