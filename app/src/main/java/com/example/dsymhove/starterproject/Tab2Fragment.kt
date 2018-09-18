package com.example.dsymhove.starterproject


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 *
 */
class Tab2Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_tab2, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.fragmentRecyclerView)
        setupRecyclerView(recyclerView)
        return rootView
    }

    fun setupRecyclerView(recyclerView: RecyclerView) {
        val list = arrayOf("blah", "blub")
        val recyclerViewAdapter = RecyclerViewAdapter(list)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
