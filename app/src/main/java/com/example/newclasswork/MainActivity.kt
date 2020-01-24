package com.example.newclasswork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newclasswork.fragment.BlanFragment
import com.example.newclasswork.fragment.FantFragment
import com.example.newclasswork.network.ResultItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, BlanFragment.newInstance())
            .commit()


    }


    fun showProfile(id: String){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FantFragment.newInstance(id))
            .addToBackStack("")
            .commit()
    }
}