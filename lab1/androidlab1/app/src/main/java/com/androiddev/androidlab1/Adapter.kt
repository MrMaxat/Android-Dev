package com.android.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.androidlab1.Vacancy
import com.androiddev.androidlab1.databinding.VacancyLayoutBinding

class Adapter : RecyclerView.Adapter<Adapter.VacancyViewHolder>() {

    var vacancyClick: ((Vacancy) -> Unit)? = null

    private var vacancyList: List<Vacancy> = listOf()

    fun updateVacancyList(newList: List<Vacancy>) {
        vacancyList = newList
        notifyDataSetChanged()
    }

    inner class VacancyViewHolder(val binding: VacancyLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val binding = VacancyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VacancyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        val vacancy = vacancyList[position]

        holder.itemView.setOnClickListener {
            vacancyClick?.invoke(vacancy)
        }

        holder.binding.apply {
            tvJobTitle.text = vacancy.title
            tvPostedDate.text = vacancy.postingDate
            tvCompanyName.text = vacancy.employerName
            tvExperience.text = vacancy.experienceRequired
            ivLogoImage.setImageResource(vacancy.employerLogo)
        }
    }

    override fun getItemCount(): Int {
        return vacancyList.size
    }
}
