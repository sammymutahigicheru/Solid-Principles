package com.sammy.solidprinciples.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sammy.solidprinciples.databinding.ActivitySolidPrinciplesDetailsBinding
import com.sammy.solidprinciples.models.SolidPrinciple
import com.sammy.solidprinciples.utils.NavigationUtils

class SolidPrinciplesDetailsActivity : AppCompatActivity() {
    private val binding: ActivitySolidPrinciplesDetailsBinding by lazy {
        ActivitySolidPrinciplesDetailsBinding.inflate(layoutInflater)
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.detailsToolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        binding.detailsToolbar.setOnClickListener {
            onBackPressed()
        }
        val solidPrinciple: SolidPrinciple =
            intent.getParcelableExtra(NavigationUtils.SOLID_PRINCIPLE_KEY)!!
        binding.detailsToolbar.title = solidPrinciple.name
        setView(solidPrinciple)
    }

    private fun setView(solidPrinciple: SolidPrinciple) {
        binding.apply {
            designPatternDescriptionTextView.text = solidPrinciple.description
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}