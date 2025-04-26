package com.vharya.latihan2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val genres = arrayListOf(
        "Shooter", "Fantasy", "Souls-like"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listview_genres)
        listView.adapter = ListAdapter(this, genres)
        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, GameListActivity::class.java)
            intent.putExtra("genre", genres[position])
            startActivity(intent)
        }
    }
}