package com.example.dsymhove.starterproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = message
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        Log.d("tag", "init recycler view")
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        val list = arrayOf("Element1", "Element2", "Element3")
        val recyclerViewAdapter = RecyclerViewAdapter(list = list)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
