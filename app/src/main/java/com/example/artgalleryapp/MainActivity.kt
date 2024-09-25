package com.example.artgalleryapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Artwork(
    val title: String,
    val artist: String,
    val year: String,
    val description: String,
    val imageResource: Int
)

class MainActivity : AppCompatActivity() {
    private var currentArtworkIndex = 0

    private val artworks = listOf(
        Artwork(
            "The Starry Night",
            "Vincent van Gogh",
            "1889",
            "A masterpiece by Vincent van Gogh, The Starry Night is one of the most recognized paintings in Western art.",
            R.drawable.starry_night
        ),
        Artwork(
            "The Mask of Agamemnon",
            "Unknown (Mycenaean)",
            "1550-1500 BC",
            "A funerary mask discovered in Mycenae, Greece, believed to represent the legendary King Agamemnon.",
            R.drawable.mask_of_agamemnon
        ),
        Artwork(
            "Perseus and Andromeda",
            "Sir Frederic Leighton",
            "1891",
            "A romantic depiction of the Greek mythological hero Perseus rescuing Andromeda from a sea monster.",
            R.drawable.perseus_and_andromeda
        ),
        Artwork(
            "The Persistence of Memory",
            "Salvador Dalí",
            "1931",
            "A surreal painting by Salvador Dalí, known for its melting clocks and dreamlike landscape.",
            R.drawable.persistence_of_memory
        ),
        Artwork(
            "The Birth of Venus",
            "Sandro Botticelli",
            "1486",
            "A famous painting of the goddess Venus, emerging from the sea on a shell, painted during the Italian Renaissance.",
            R.drawable.birth_of_venus
        )
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadArtwork(currentArtworkIndex)

        val previousButton: Button = findViewById(R.id.previousButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        previousButton.setOnClickListener {
            if (currentArtworkIndex > 0) {
                currentArtworkIndex--
                loadArtwork(currentArtworkIndex)
            }
        }

        nextButton.setOnClickListener {
            if (currentArtworkIndex < artworks.size - 1) {
                currentArtworkIndex++
                loadArtwork(currentArtworkIndex)
            }
        }
    }

    private fun loadArtwork(index: Int) {
        val artImageView: ImageView = findViewById(R.id.artImageView)
        val artTitleTextView: TextView = findViewById(R.id.artTitleTextView)
        val artistTextView: TextView = findViewById(R.id.artistTextView)

        val artwork = artworks[index]

        artImageView.setImageResource(artwork.imageResource)
        artTitleTextView.text = artwork.title
        artistTextView.text = "${artwork.artist}, ${artwork.year}"
    }

}
