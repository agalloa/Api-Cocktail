package com.example.project_api

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.project_api.ui.Fav_fragment
import com.example.project_api.ui.Main_Fragment

class ViewPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    companion object {
        private const val ARG_OBJECT = "object"
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            1 -> {
                return Main_Fragment()
            }
            2 -> {
                return Fav_fragment()
            }
        }
        val fragment = Main_Fragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}
