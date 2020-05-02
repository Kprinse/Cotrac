package com.kyleprince.cotrac.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.kyleprince.cotrac.MySingleton
import com.kyleprince.cotrac.R
import com.google.gson.Gson

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)

        val newsButton: Button = root.findViewById(R.id.newsButton)
        val newsListView: ListView = root.findViewById(R.id.newsListView)
        val adapter = ArrayAdapter<String>(root.context, android.R.layout.simple_list_item_1, newsViewModel.newsList)
        var result: String = ""

        newsListView.adapter = adapter

        val url = "https://newsapi.org/v2/everything?q=COVID&from=2020-04-20&sortBy=publishedAt&apiKey=33ee60e95d08450a819708d931b6ba38&pageSize=50&page=1"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                result = response.toString()
            },
            Response.ErrorListener { error ->
                // TODO: Handle error
            }
        )

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(root.context).addToRequestQueue(jsonObjectRequest)

        newsButton.setOnClickListener {
            val news = Gson().fromJson(result.toString(), News::class.java)
            newsViewModel.newsList.clear()
            for (article in news.articles) newsViewModel.newsList.add(article.title)
            adapter.notifyDataSetChanged()
        }

        return root
    }
}
