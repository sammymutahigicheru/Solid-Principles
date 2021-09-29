package com.sammy.solidprinciples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sammy.solidprinciples.databinding.ActivityMainBinding
import com.sammy.solidprinciples.models.generateSolidPrinciples
import com.sammy.solidprinciples.ui.SolidPrincipleAdapter
import com.sammy.solidprinciples.utils.GridSpaceItemDecoration
import com.sammy.solidprinciples.utils.ViewUtils

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        val solidPrinciples = generateSolidPrinciples()
        val solidPrincipleAdapter = SolidPrincipleAdapter{

        }
        val spacing = ViewUtils.convertDpToPixel(this,8)
        binding.solidPrinciplesRecycler.apply {
            adapter = solidPrincipleAdapter
            addItemDecoration(GridSpaceItemDecoration(spacing))
            hasFixedSize()
        }
        solidPrincipleAdapter.submitList(solidPrinciples)
    }
}