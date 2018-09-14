package com.example.dsymhove.starterproject


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


const val EXTRA_MESSAGE = "com.example.starterproject.MESSAGE"

/**
 * A simple [Fragment] subclass.
 *
 */
class Tab1Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)
        val sendButton = view.findViewById<Button>(R.id.sendButton)
        val editText = view.findViewById<EditText>(R.id.editText)
        sendButton.setOnClickListener { v: View ->  onClick(v, editText.text.toString())}
        return view
    }

    private fun onClick(view: View, message: String) {
        val intent = Intent(activity, DisplayMessageActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}
