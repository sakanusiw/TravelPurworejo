package com.example.travelpurworejo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelpurworejo.RecyclerView.MyAdapter

class HomeActivity : AppCompatActivity() {

    private val dataList: List<LokasiWisata> = mutableListOf(
        LokasiWisata("Item 1"),
        LokasiWisata("Item 2"),
        LokasiWisata("Another Item"),
        // Add more items to your dataList
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // Use other layout managers for grid, staggered grid, etc.

        val imageResources = mutableListOf<Int>() // Replace with a list of drawable resources
        // Add resource IDs to imageResources here
        imageResources.add(R.drawable.curug_lumbung)
        imageResources.add(R.drawable.curug_lumbung)
        imageResources.add(R.drawable.curug_lumbung)

        val adapter = MyAdapter(imageResources)
        recyclerView.adapter = adapter
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
        val filteredList = dataList.filter { dataItem ->
            // Perform case-insensitive search based on the 'name' property
            dataItem.name.contains(query ?: "", ignoreCase = true)
        }

        // Now, 'filteredList' contains the filtered data based on the search query
        // You can use this filtered data to update your UI or display search results.
        // For example, update a RecyclerView or ListView with the filtered data.
    }
}

// Replace YourDataItem with your actual data item class.
data class LokasiWisata(val name: String)