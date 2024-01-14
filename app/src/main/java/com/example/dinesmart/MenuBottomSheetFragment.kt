package com.example.dinesmart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dinesmart.adapter.MenuAdapter
import com.example.dinesmart.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        val menuFoodName = listOf("Dahi Samosa","Dahi Kachori","Dosa","Sambar Vada")
        val menuItemPrice = listOf("40rs","40rs","80rs","40rs")
        val menuImage = listOf(
            R.drawable.m_dahisamosa,R.drawable.m_dahikachori,R.drawable.m_dosa ,R.drawable.m_sambarvada
        )
        val menudescription = listOf(
            "Dahi Samosa is a popular Indian street food made from crispy fried samosas that are filled with spiced potato and served with a generous topping of yogurt, chutneys, and spices.",
            "Dahi Kachori is a North Indian snack that consists of deep-fried pastry balls filled with a mixture of lentils and spices, typically served with yogurt and various chutneys.",
            "Idli is a South Indian steamed rice cake made from fermented rice and urad dal (black gram) batter, usually served with coconut chutney and sambar.",
            "Sambar Vada is a South Indian dish consisting of deep-fried lentil-based vadas (fritters) soaked in hot and tangy sambar, a spicy lentil-based soup with vegetables and spices.",
        )
        val menuingredient = listOf(
            "Samosas, yogurt, chutneys, spices, garnishes.",
            "Kachori, yogurt, chutneys, spices, garnishes.",
            "Rice\n" +
                    "Urad dal (black gram)\n" +
                    "Salt\n" +
                    "Water",
            "masala",
        )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext(),menudescription,menuingredient)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
        return binding.root
    }

    companion object {

    }
}