package com.example.dsymhove.starterproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.profile_list_item.view.*

class ProfileRecyclerViewAdapter(list: Array<Profile>): RecyclerView.Adapter<ProfileRecyclerViewAdapter.ProfileViewHolder>() {

    private val list = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileRecyclerViewAdapter.ProfileViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.profile_list_item, parent, false)
        return ProfileViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.nameTextView.text = list[position].name
        holder.emailTextView.text = list[position].email
        holder.phoneTextView.text = list[position].phone
        //holder.imageView.setImageResource(list[position].drawable!!)
    }

    class ProfileViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView = view.profile_image
        val layout = view.profile_list_item_layout
        val nameTextView = view.name_textView
        val emailTextView = view.email_textView
        val phoneTextView = view.phone_textView
    }
}