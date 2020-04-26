package com.kyleprince.cotrac.ui.search

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kyleprince.cotrac.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        val countryListView: ListView = root.findViewById(R.id.countryListView)
        val adapter = ArrayAdapter<String>(root.context, android.R.layout.simple_list_item_1, homeViewModel.countryList)
        val searchButton: Button = root.findViewById(R.id.searchButton)

        countryListView.adapter = adapter

        searchButton.setOnClickListener {
            homeViewModel.updateCountryList()
            adapter.notifyDataSetChanged()
        }

        return root
    }

}
