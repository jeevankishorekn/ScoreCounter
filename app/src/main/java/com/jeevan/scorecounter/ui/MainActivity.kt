package com.jeevan.scorecounter.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.jeevan.scorecounter.databinding.ActivityMainBinding
import com.jeevan.scorecounter.receivers.BatteryLowReceiver
import com.jeevan.scorecounter.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel : MainViewModel by viewModels()

        var filter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        ContextCompat.registerReceiver(applicationContext,BatteryLowReceiver(), filter, ContextCompat.RECEIVER_NOT_EXPORTED)

        mainViewModel.teamOneScore.observe(this){
            binding.scoreA.text = mainViewModel.teamOneScore.value.toString()
        }

        mainViewModel.teamTwoScore.observe(this){
            binding.scoreB.text = mainViewModel.teamTwoScore.value.toString()
        }

        binding.pointA1.setOnClickListener{
            mainViewModel.addOnePointA()
        }

        binding.pointA2.setOnClickListener{
            mainViewModel.addTwoPointsA()
        }

        binding.pointA3.setOnClickListener{
            mainViewModel.addThreePointsA()
        }
        binding.pointB1.setOnClickListener{
            mainViewModel.addOnePointB()
        }

        binding.pointB2.setOnClickListener{
            mainViewModel.addTwoPointsB()
        }

        binding.pointB3.setOnClickListener{
            mainViewModel.addThreePointsB()
        }

        binding.reset.setOnClickListener{
            mainViewModel.reset()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(BatteryLowReceiver())
    }
}