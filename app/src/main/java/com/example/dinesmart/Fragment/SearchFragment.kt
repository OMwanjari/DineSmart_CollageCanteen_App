package com.example.dinesmart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dinesmart.R
import com.example.dinesmart.adapter.MenuAdapter
import com.example.dinesmart.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var bindinq:FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf(
        "Dahi Samosa","Dahi Kachori","Dosa","Sambar Vada"
    )
    private val originalMenuItemPrice = listOf("40rs","40rs","80rs","40rs")
    private val originaldescription = listOf(
        "Dahi Samosa is a popular Indian street food made from crispy fried samosas that are filled with spiced potato and served with a generous topping of yogurt, chutneys, and spices.",
        "Dahi Kachori is a North Indian snack that consists of deep-fried pastry balls filled with a mixture of lentils and spices, typically served with yogurt and various chutneys.",
        "Idli is a South Indian steamed rice cake made from fermented rice and urad dal (black gram) batter, usually served with coconut chutney and sambar.",
        "Sambar Vada is a South Indian dish consisting of deep-fried lentil-based vadas (fritters) soaked in hot and tangy sambar, a spicy lentil-based soup with vegetables and spices.",
    )
   private val originalingredient = listOf(
        "Samosas, yogurt, chutneys, spices, garnishes.",
        "Kachori, yogurt, chutneys, spices, garnishes.",
        "Rice\n" +
                "Urad dal (black gram)\n" +
                "Salt\n" +
                "Water",
        "masala",
    )
   private val originalMenuImage = listOf(
        R.drawable.m_dahisamosa,R.drawable.m_dahikachori,R.drawable.m_dosa ,R.drawable.m_sambarvada
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindinq = FragmentSearchBinding.inflate(inflater,container,false)

        adapter = MenuAdapter(originalMenuFoodName,originalMenuItemPrice,originalMenuImage,requireContext(),originaldescription,originalingredient)
        bindinq.menuRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        bindinq.menuRecyclerView.adapter = adapter

        return bindinq.root
    }

    companion object {


    }
}