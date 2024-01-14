package com.example.dinesmart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinesmart.databinding.CartItemBinding

class CartAdapter( private val cartItems:MutableList<String>, private val CartItemPrice:MutableList<String>, private var CartImage:MutableList<Int> ) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
   private val itemQuentities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

   inner class CartViewHolder(private val binding:CartItemBinding):RecyclerView.ViewHolder(binding.root) {
         fun bind(position: Int){
               binding.apply {
                   val quantity = itemQuentities[position]
                   cartFoodName.text=cartItems[position]
                   cartItemPrice.text = CartItemPrice[position]
                   cartImage.setImageResource(CartImage[position])
                   CartItemquantity.text = quantity.toString()

                   minusbutton.setOnClickListener{
                       decreaseQuantity(position)
                   }
                   plusbutton.setOnClickListener{
                         increaseQuantity(position)
                   }
                   deletebutton.setOnClickListener{
                         val itemPosition = adapterPosition
                       if(itemPosition != RecyclerView.NO_POSITION)
                       {
                           deleteItem(itemPosition)
                       }
                   }
               }
         }
       private fun decreaseQuantity(position: Int){
           if(itemQuentities[position]>1)
           {
               itemQuentities[position]--
               binding.CartItemquantity.text = itemQuentities[position].toString()
           }
       }
       private fun increaseQuantity(position: Int){
           if(itemQuentities[position]<10)
           {
               itemQuentities[position]++
               binding.CartItemquantity.text = itemQuentities[position].toString()
           }
       }
       private fun deleteItem(position: Int)
       {
           cartItems.removeAt(position)
           CartImage.removeAt(position)
           CartItemPrice.removeAt(position)
           notifyItemRemoved(position)
           notifyItemRangeChanged(position,cartItems.size)
       }
    }
}