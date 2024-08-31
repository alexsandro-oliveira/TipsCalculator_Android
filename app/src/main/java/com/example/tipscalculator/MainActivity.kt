package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_TOTAL_BILL = "MainActivity.KEY_TOTAL_BILL"
const val KEY_TIP = "MainActivity.KEY_CHOSE_TIP"
const val KEY_TOTAL_TIP = "MainActivity.KEY_TOTAL_TIP"
const val KEY_PEOPLE = "MainActivity.KEY_N_PEOPLE"
const val KEY_RESULT = "MainActivity.KEY_RESULT"


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var percentage: Int = 0
        binding.rbOpt1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOpt2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOpt3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnCalc.setOnClickListener {
            val billTotalTemp = binding.tieBill.text
            val nPeopleTemp = binding.tiePerson.text

            if (billTotalTemp?.isEmpty() == true || nPeopleTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieBill, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val billTotal: Float = billTotalTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()
                val totalTips: Float = (billTotal * percentage) / 100
                val billWithTip: Float = billTotal + totalTips
                val totalPerPerson: Float = billWithTip / nPeople


                val intent = Intent(this, SummaryActivity::class.java)
                intent.putExtra(KEY_TOTAL_BILL, billTotal)
                intent.putExtra(KEY_TIP, percentage)
                intent.putExtra(KEY_TOTAL_TIP, totalTips)
                intent.putExtra(KEY_PEOPLE, nPeople)
                intent.putExtra(KEY_RESULT, totalPerPerson)

                startActivity(intent)
            }
        }

        binding.btnClear.setOnClickListener {
            binding.rbOpt1.isChecked = false
            binding.rbOpt2.isChecked = false
            binding.rbOpt3.isChecked = false
            binding.tieBill.setText("")
            binding.tiePerson.setText("")
        }
    }
}