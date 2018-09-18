package com.example.dsymhove.starterproject


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 *
 */
class Tab3Fragment : Fragment() {

    private var displayValue: Int
        get() {
            return textView.text.toString().toInt()
        }
        set(value) {
            textView.text = value.toString()
        }

    private lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tab3, container, false)
        val clickMeButton = rootView.findViewById<Button>(R.id.click_me_button)
        textView = rootView.findViewById<TextView>(R.id.counter_text_view)

        clickMeButton.setOnClickListener { v ->
            Log.d("tag", "ClickMeButton Pressed")
            displayValue += 1
        }
        return rootView
    }


}
