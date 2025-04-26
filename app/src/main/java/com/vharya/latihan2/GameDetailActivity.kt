package com.vharya.latihan2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageExtra = intent.getIntExtra("image", 0)
        val titleExtra = intent.getStringExtra("title")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val imageView = findViewById<ImageView>(R.id.game_image)
        val textView = findViewById<TextView>(R.id.game_title)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_left)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = "Game Details"

        imageView.setImageResource(imageExtra)
        textView.text = titleExtra
    }
}