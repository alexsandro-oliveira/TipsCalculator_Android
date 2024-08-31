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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)

        val totalBill = intent.getFloatExtra(KEY_TOTAL_BILL, 0f)
        val choseTip = intent.getIntExtra(KEY_TIP, 0)
        val totalTip = intent.getFloatExtra(KEY_TOTAL_TIP, 0f)
        val nPeople = intent.getIntExtra(KEY_PEOPLE, 0)
        val resultCalc = intent.getFloatExtra(KEY_RESULT, 0f)

        val result: TextView = findViewById(R.id.tv_result)
        val billResult: TextView = findViewById(R.id.tv_billResult)
        val tipResult: TextView = findViewById(R.id.tv_tipResult)
        val tipTotal: TextView = findViewById(R.id.tv_tipTotalResult)
        val people: TextView = findViewById(R.id.tv_nPeopleResult)

        result.text = "$ %.2f".format(resultCalc)
        billResult.text = "$ %.2f".format(totalBill)
        tipResult.text = choseTip.toString()+"%"
        tipTotal.text = "$ %.2f".format(totalTip)
        people.text = nPeople.toString()

        val btnNew: Button = findViewById(R.id.btn_new)

        btnNew.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}