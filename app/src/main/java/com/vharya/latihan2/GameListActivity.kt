package com.vharya.latihan2

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameListActivity : AppCompatActivity() {
    private val shooterImages = arrayListOf(
        R.drawable.c2, R.drawable.c3,
        R.drawable.c5
    )

    private val fantasyImages = arrayListOf(
        R.drawable.c4, R.drawable.c6,
        R.drawable.c7, R.drawable.c8
    )

    private val soulsImages = arrayListOf(
        R.drawable.c6, R.drawable.c7
    )

    private val shooterNames = arrayListOf(
        "Cyberpunk 2077", "Far Cry 4",
        "Red Dead Redemption 2"
    )

    private val fantasyNames = arrayListOf(
        "The Witcher 3", "Bloodborne",
        "Elden Ring", "Assassin's Creed Revalation"
    )

    private val soulsNames = arrayListOf(
        "Bloodborne", "Elden Ring"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genre = intent.getStringExtra("genre")

        val gridView = findViewById<GridView>(R.id.gridview_games)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val images: ArrayList<Int>
        val titles: ArrayList<String>

        when (genre) {
            "Shooter" -> {
                images = shooterImages
                titles = shooterNames
            }
            "Fantasy" -> {
                images = fantasyImages
                titles = fantasyNames
            }
            else -> {
                images = soulsImages
                titles = soulsNames
            }
        }

        toolbar.setNavigationIcon(R.drawable.ic_arrow_left)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = genre

        gridView.adapter = GridAdapter(this, images, titles)
        gridView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@GameListActivity, GameDetailActivity::class.java)
            intent.putExtra("image", images[position])
            intent.putExtra("title", titles[position])
            startActivity(intent)
        }
    }
}