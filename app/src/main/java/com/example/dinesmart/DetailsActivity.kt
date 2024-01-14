package com.example.dinesmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dinesmart.Fragment.CartFragment
import com.example.dinesmart.adapter.CartAdapter
import com.example.dinesmart.databinding.ActivityDetailsBinding
import com.example.dinesmart.databinding.ActivityPayOutBinding
import com.example.dinesmart.databinding.FragmentCartBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage",0)
        val foodDescription = intent.getStringExtra("MenuItemDescription")
        val foodIngredient = intent.getStringExtra("MenuItemIngredient")
        binding.detailFoodName.text = foodName
        binding.detailFoodImage.setImageResource(foodImage)
        binding.destext.text = foodDescription
        binding.ingredientTextView.text = foodIngredient
        binding.imageButton.setOnClickListener{
            finish()
        }

        binding.cartbutton.setOnClickListener{
            Toast.makeText(this@DetailsActivity, " Added to Cart", Toast.LENGTH_SHORT).show()

        }

    }

}