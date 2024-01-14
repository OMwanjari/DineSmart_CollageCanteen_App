package com.example.dinesmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinesmart.DetailsActivity
import com.example.dinesmart.databinding.FragmentHomeBinding
import com.example.dinesmart.databinding.PopularItemBinding

class PopularAdapter( private val items:List<String> ,private val price:List<String> , private val image:List<Int> , private val requiredContext:Context,private val desciption:List<String>,private val ingredient:List<String>) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        val desc = desciption[position]
        val ingri = ingredient[position]
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener{
            val intent = Intent(requiredContext , DetailsActivity::class.java)
            intent.putExtra("MenuItemName", item)
            intent.putExtra("MenuItemImage", images)
            intent.putExtra("MenuItemDescription", desc)
            intent.putExtra("MenuItemIngredient", ingri)
            requiredContext.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PopularViewHolder (private val binding: PopularItemBinding):RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.imageView5
        fun bind(item: String,price: String, images: Int) {
            binding.foodNamePopular.text = item
            binding.PricePopular.text = price
            imagesView.setImageResource(images)
        }

    }
}