package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.example.tipscalculator.databinding.ActivitySummaryBinding
import java.util.Locale

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate((layoutInflater))
        setContentView(binding.root)

        val totalBill = intent.getFloatExtra("billTotal", 0.0f)
        val choseTip = intent.getIntExtra("percentage", 0)
        val totalTip = intent.getFloatExtra("totalTips", 0.0f)
        val nPeople = intent.getIntExtra("nPeople", 0)
        val resultCalc = intent.getFloatExtra("totalPerPerson", 0.0f)

        binding.tvResult.text = "$ %.2f".format(resultCalc)
        binding.tvBillResult.text = "$ %.2f".format(totalBill)
        binding.tvTipResult.text = "$choseTip%"
        binding.tvTipTotalResult.text = "$ %.2f".format(totalTip)
        binding.tvNPeopleResult.text = nPeople.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }

    }
}