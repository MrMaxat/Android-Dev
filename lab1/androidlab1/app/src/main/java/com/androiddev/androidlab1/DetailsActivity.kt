package com.androiddev.androidlab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androiddev.androidlab1.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vacancy = intent.getParcelableExtra<Vacancy>("vacancy")

        binding.tvJobTitle.text = vacancy?.title
        binding.tvCompanyName.text = vacancy?.employerName
        binding.tvSalary.text = "от ${vacancy?.offeredSalary} ₸"
        binding.tvExperience.text = vacancy?.experienceRequired
        binding.tvJobType.text = vacancy?.employmentType
        binding.tvDescription.text = vacancy?.jobDescription
        binding.tvCompanyAddress.text = vacancy?.location
        vacancy?.employerLogo?.let { binding.imgCompanyLogo.setImageResource(it) }

        binding.tvApplicants.text = "${vacancy?.applicantsCount} человек уже откликнулось"
        binding.tvCurrentViewers.text = "${vacancy?.viewersCount} человек смотрят в данный момент"
    }
}
