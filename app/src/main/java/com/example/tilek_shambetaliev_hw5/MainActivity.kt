package com.example.tilek_shambetaliev_hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tilek_shambetaliev_hw5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView{
    lateinit var binding: ActivityMainBinding
    private val presenter=Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding){
            btnIncrement.setOnClickListener {
presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.tvCount.text=count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }
}