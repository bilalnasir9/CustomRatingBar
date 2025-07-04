package com.github.bilalnasir9.customratingbar

import android.os.Bundle
import android.widget.Toast
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

        binding.ratingBar.setOnRatingBarChangeListener = { newRating, fromUser ->
        }
        binding.btnGetrating.setOnClickListener {
            Toast.makeText(
                this,
                "User picked ${binding.ratingBar.rating} stars", Toast.LENGTH_SHORT
            ).show()

            binding.ratingBar.rating=4.5f
        }

//        binding.ratingBar.setIcons(
//            filled = R.drawable.ic_star_filled,
//            empty  = R.drawable.ic_star_outline,
//            half   = R.drawable.ic_star_half
//        )


//        binding.ratingBar.rating(4.5f)
//        val current = binding.ratingBar.getRating()

    }
}