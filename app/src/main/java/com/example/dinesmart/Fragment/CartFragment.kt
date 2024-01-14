package com.example.dinesmart.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dinesmart.CongratsBottomSheet
import com.example.dinesmart.R
import com.example.dinesmart.adapter.CartAdapter
import com.example.dinesmart.databinding.CartItemBinding
import com.example.dinesmart.databinding.FragmentCartBinding
import com.example.dinesmart.pay_out

class CartFragment : Fragment() {

   private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Dosa",)
        val cartItemPrice = listOf("80rs")
        val cartImage = listOf(
           R.drawable.m_dosa
        )
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter
        binding.proceedbutton.setOnClickListener{
            val intent = Intent(requireContext(),pay_out::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}