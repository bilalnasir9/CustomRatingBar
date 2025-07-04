package com.github.bilalnasir9.customratingbar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.bilalnasir9.customratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ratingBar.setOnRatingBarChangeListener = { newRating ,_ ->
                Log.d("TAG", "Rating: $newRating")
        }
        binding.btnFivestars.setOnClickListener {
            binding.ratingBar.rating = 5f
        }

//        binding.ratingBar.setIcons(
//            filled = R.drawable.ic_star_filled,
//            empty  = R.drawable.ic_star_outline,
//            half   = R.drawable.ic_star_half
//        )

//        val getRating = binding.ratingBar.rating

    }
}