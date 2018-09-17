package com.example.dsymhove.starterproject

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false) as TextView
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("tag", "onBindViewHolder called")

        holder.textView.text = "This is my first Recycler View"
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

    }
}