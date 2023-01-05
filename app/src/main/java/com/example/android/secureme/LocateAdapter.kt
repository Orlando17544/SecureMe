package com.example.android.secureme

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.secureme.map.MapFragment
import com.example.android.secureme.query.QueryFragment

class LocateAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> QueryFragment()
            1 -> MapFragment()
            else -> Fragment()
        }
    }
}