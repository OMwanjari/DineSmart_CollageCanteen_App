package com.example.dinesmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.car.ui.toolbar.MenuItem.OnClickListener
import com.example.dinesmart.DetailsActivity
import com.example.dinesmart.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName: List<String>, private val menuItemPrice: List<String>, private val MenuImage: List<Int>,private val requiredContext: Context, private val Menudesciption:List<String>,private val Menuingredient:List<String>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener:OnClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
            holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding :MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                val intent = Intent(requiredContext ,DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItemsName.get(position))
                intent.putExtra("MenuItemImage", MenuImage.get(position))
                intent.putExtra("MenuItemDescription", Menudesciption.get(position))
                intent.putExtra("MenuItemIngredient", Menuingredient.get(position))
                requiredContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
                binding.apply {
                    menufoodName.text=menuItemsName[position]
                    menuPrice.text=menuItemPrice[position]
                    menuImage.setImageResource(MenuImage[position])

                }
        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}


