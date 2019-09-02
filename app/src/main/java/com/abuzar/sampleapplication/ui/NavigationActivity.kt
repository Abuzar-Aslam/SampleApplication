package com.abuzar.sampleapplication.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.base.BaseFragment

/**
 * Created by ABUZAR on 9/1/2019.
 */

class NavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        supportActionBar?.title = "Artist"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            android.R.id.home -> onBackButtonPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.navHostFragment).navigateUp()


    private fun onBackButtonPressed() {
        val fragment =
            supportFragmentManager.fragments[0].childFragmentManager.fragments.last() as BaseFragment<ViewDataBinding>
        fragment.onBackButtonPressed()
    }

}