package com.example.dinesmart

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dinesmart.databinding.ActivityFirstBinding
import com.example.dinesmart.databinding.ActivityPayOutBinding

class First : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.one,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.two,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.three,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.four,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.five,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList , ScaleTypes.FIT)

        binding.getstarted.setOnClickListener{
            val intent = Intent(this , LogIn::class.java)
            startActivity(intent)
        }
    }


}