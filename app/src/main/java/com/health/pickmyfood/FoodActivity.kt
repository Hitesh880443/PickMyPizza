package com.health.pickmyfood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.health.pickmyfood.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodViewModel
    private lateinit var viewDataBinding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_food)
        setupViewModel()
        setupUI()
    }


    private fun setupUI() {

        viewDataBinding.btnPick.setOnClickListener {
            viewModel.pickMyPizza()
        }

        viewModel.myPizza.observe(this, { food ->
            food?.let {
                viewDataBinding.tvName.text = it.foodName
                viewDataBinding.tvPrice.text = it.price.toString()
                viewDataBinding.tvRating.text = it.rating.toString()
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory()
        ).get(FoodViewModel::class.java)
    }
}