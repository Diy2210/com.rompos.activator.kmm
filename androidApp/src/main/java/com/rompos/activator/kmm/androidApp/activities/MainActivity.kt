package com.rompos.activator.kmm.androidApp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rompos.activator.kmm.androidApp.R
import com.rompos.activator.kmm.androidApp.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    private var listFragment = ListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_view, listFragment)
                .commitAllowingStateLoss()
        }
    }
}
