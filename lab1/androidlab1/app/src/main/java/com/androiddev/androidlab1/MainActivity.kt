package com.androiddev.androidlab1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.assignment1.Adapter
import com.androiddev.androidlab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var vacancies = getList()
    val vacancyAdapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvVacancies.adapter = vacancyAdapter
        binding.rvVacancies.layoutManager = LinearLayoutManager(this)

        vacancyAdapter.updateVacancyList(getList())
        vacancyAdapter.vacancyClick = {
            val intent  = Intent(this, DetailsActivity::class.java)
            intent.putExtra("vacancy", it)
            startActivity(intent)
        }
        binding.etSearchVacancies.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                search(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }

    fun search(query: String) {
        val filteredVacancies = vacancies.filter { vacancy ->
            vacancy.title.contains(query, ignoreCase = true)
        }

        vacancyAdapter.updateVacancyList(filteredVacancies)
    }
}


fun getList():List<Vacancy>{
    return listOf(
        Vacancy(1, title = "Android developer", "Company name", 300000, "Требует опыт от 1 года до 3", "address", "15 december", "full time", "Description", R.drawable.img, 1,1 ),
        Vacancy(2, title = "Android developer", "Company name", 300000, "Требует опыт от 1 года до 3", "address", "15 december", "full time", "Description", R.drawable.img, 1,1 ),
        Vacancy(3, title = "Android developer", "Company name", 300000, "Требует опыт от 1 года до 3", "address", "15 december", "full time", "Description", R.drawable.img, 1,1 ),
        Vacancy(4, title = "Android developer", "Company name", 300000, "Требует опыт от 1 года до 3", "address", "15 december", "full time", "Description", R.drawable.img, 1,1 ),
        Vacancy(5, title = "Android developer", "Company name", 300000, "Требует опыт от 1 года до 3", "address", "15 december", "full time", "Description", R.drawable.img, 1,1 ),
    )
}