package com.example.dinesmart.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dinesmart.MenuBottomSheetFragment
import com.example.dinesmart.R
import com.example.dinesmart.adapter.PopularAdapter
import com.example.dinesmart.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
   private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.ViewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.p2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.p3,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.p1,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList , ScaleTypes.FIT)

        val foodName = listOf("Dahi Samosa","Dahi Kachori", "Idli", "Sambar Vada", "Dosa")
        val Price = listOf("40 rs", "40 rs","30 rs","40 rs" ,"80 rs")
        val popularFoodImages = listOf(R.drawable.m_dahisamosa,R.drawable.m_dahikachori,R.drawable.m_idli,R.drawable.m_sambarvada,R.drawable.m_dosa)
        val description = listOf(
            "Dahi Samosa is a popular Indian street food made from crispy fried samosas that are filled with spiced potato and served with a generous topping of yogurt, chutneys, and spices.",
            "Dahi Kachori is a North Indian snack that consists of deep-fried pastry balls filled with a mixture of lentils and spices, typically served with yogurt and various chutneys.",
            "Idli is a South Indian steamed rice cake made from fermented rice and urad dal (black gram) batter, usually served with coconut chutney and sambar.",
            "Sambar Vada is a South Indian dish consisting of deep-fried lentil-based vadas (fritters) soaked in hot and tangy sambar, a spicy lentil-based soup with vegetables and spices.",
            "Dosa is a popular South Indian pancake or crepe made from fermented rice and urad dal (black gram) batter, typically served with coconut chutney and sambar.",
        )
        val ingredient = listOf(
            "Samosas\n yogurt,\nchutneys\n spices\n garnishes.",
            "Kachori\n yogurt\n chutneys\n spices\n garnishes.",
            "Rice\n" +
                    "Urad dal (black gram)\n" +
                    "Salt\n" +
                    "Water",
            "Vada (deep-fried lentil doughnuts)\n" +
                    "Sambar (spicy lentil stew)\n" +
                    "Garnishes and spices.",
            "Rice and urad dal batter\n" +
                    "Oil or ghee\n" +
                    "Salt",
        )
        val adapter = PopularAdapter(foodName, Price , popularFoodImages , requireContext() ,description , ingredient)
        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter
    }

    companion object {

    }
}