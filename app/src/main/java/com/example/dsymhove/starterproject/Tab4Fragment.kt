package com.example.dsymhove.starterproject


import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

/**
 * A simple [Fragment] subclass.
 *
 */
class Tab4Fragment : Fragment() {

    private var profiles : MutableList<Profile> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private val ONE_MEGABYTE: Long = 2024 * 2024

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tab4, container, false)
        recyclerView = rootView.findViewById<RecyclerView>(R.id.profile_recycler_view)
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("users")
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.getReferenceFromUrl("gs://jambit-academy-7ea09.appspot.com/astefano.png")

        reference.orderByKey().addValueEventListener(itemListener)

        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener { bytes ->
            val bmp = BitmapFactory.decodeByteArray(bytes,0, bytes.size)

        }
        return rootView
    }

    var itemListener: ValueEventListener = object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            addProfileToList(p0)
        }

        override fun onCancelled(p0: DatabaseError?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private fun addProfileToList(dataSnapshot: DataSnapshot) {
        val snapshotList = dataSnapshot.children.mapNotNullTo(profiles) {
            it.getValue<Profile>(Profile::class.java)
        }

        /*for (snapshot in snapshotList) {
            val profile = snapshot.getValue(Profile::class.java)!!
            profiles.add(profile)
        }
        */
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {

        val adapter = ProfileRecyclerViewAdapter(profiles)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
