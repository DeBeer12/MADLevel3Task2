package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnAddPortal).setOnClickListener {
            val fragment = AddPortalFragment()
            val portal = Portal(etTitle.toString(), etUrl.toString())
            val bundle = Bundle()
            bundle.putParcelable("portalInfo", portal)
            fragment.setArguments(bundle)
            getFragmentManager()?.beginTransaction()?.add(R.id.addPortalFragment, fragment)
                ?.commit()
            findNavController().navigate(R.id.action_addPortalFragment_to_portalFragment)
        }
    }
}