package com.example.travelpurworejo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView
        searchView?.queryHint = "Type here"
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // This method is called when the user submits the search query
                // Perform the search operation here
                // Example: Call a method to filter search results based on the query
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // This method is called when the user changes the search query text
                // You can implement live search here if desired
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun performSearch(query: String?) {
        // Implement your search logic here
        // For example, you can filter a list of items based on the query
    }
}