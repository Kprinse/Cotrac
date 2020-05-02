package com.kyleprince.cotrac.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.kyleprince.cotrac.R
import com.kyleprince.cotrac.MySingleton

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        val countryListView: ListView = root.findViewById(R.id.countryListView)
        val adapter = ArrayAdapter<String>(root.context, android.R.layout.simple_list_item_1, homeViewModel.countryList)
        val searchButton: Button = root.findViewById(R.id.searchButton)

        countryListView.adapter = adapter

        searchButton.setOnClickListener {
            homeViewModel.updateCountryList()
            adapter.notifyDataSetChanged()
        }

        val url = "https://covid-api.com/api/regions"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                //textView.text = "Response: %s".format(response.toString())
                //homeViewModel.countryList.add(response.toString())
                val countryArray = response.getJSONArray("data")
                for (i in 0 until countryArray.length()) {
                    val country = countryArray.getJSONObject(i).get("name")
                    homeViewModel.countryList.add(country.toString())
                }
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(root.context).addToRequestQueue(jsonObjectRequest)

        return root
    }

}
