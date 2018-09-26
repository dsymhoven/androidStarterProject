package com.example.dsymhove.starterproject


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass.
 *
 */
class Tab4Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tab4, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.profile_recycler_view)
        setupRecyclerView(recyclerView)
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("users")
        reference.orderByKey().addValueEventListener(itemListener)

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
        val items = dataSnapshot.children.iterator()

        if (items.hasNext()) {
            val index = items.next()
            val iterator = index.children.iterator()

            if (iterator.hasNext()) {
                val currentItem = iterator.next()
                val map = currentItem.getValue() as HashMap<String, Any>
                val name = map.get("name") as String?
                val lastname = map.get("lastname") as String?
                val mail = map.get("mail") as String?
                val phone = map.get("phone") as String?
                val profile = Profile(name = name + lastname, email = mail, phone = phone, drawable = null)
                var profiles = emptyArray<Profile>()
                profiles.plus(profile)
            }
        }


    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        /*val profiles: Array<Profile> = arrayOf(Profile(name = "David", email = "david.symhoven@jambit.com", phone = "566", drawable =  R.drawable.david),
                Profile(name = "Sebastian", email = "sebastian.cohausz@jambit.com", phone = "123", drawable = R.drawable.david),
                Profile(name = "Tobi", email = "tobias.schroepf@jambit.com", phone = "666", drawable = R.drawable.david))
                */
        val adapter = ProfileRecyclerViewAdapter(profiles)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
