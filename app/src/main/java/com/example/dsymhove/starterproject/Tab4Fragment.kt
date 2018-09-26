package com.example.dsymhove.starterproject


import android.media.ImageReader
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        return rootView
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val profiles: Array<Profile> = arrayOf(Profile(name = "David", email = "david.symhoven@jambit.com", phone = "566", drawable =  R.drawable.david),
                Profile(name = "Sebastian", email = "sebastian.cohausz@jambit.com", phone = "123", drawable = R.drawable.david),
                Profile(name = "Tobi", email = "tobias.schroepf@jambit.com", phone = "666", drawable = R.drawable.david))
        val adapter = ProfileRecyclerViewAdapter(profiles)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }


}
