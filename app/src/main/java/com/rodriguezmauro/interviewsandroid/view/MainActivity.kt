package com.rodriguezmauro.interviewsandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.rodriguezmauro.interviewsandroid.databinding.ActivityMainBinding
import com.rodriguezmauro.interviewsandroid.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // importante

        // observer para obtener cambios en el livedata del viewmodel
        quoteViewModel.quoteModel.observe(this) {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        }

        // Evento de lógica del viewModel que vá al model e impacta en el LiveData
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}
