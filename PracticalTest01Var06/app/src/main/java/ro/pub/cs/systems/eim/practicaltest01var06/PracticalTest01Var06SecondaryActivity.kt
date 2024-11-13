package ro.pub.cs.systems.eim.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val val1 = intent.getStringExtra("Val1")
        val val2 = intent.getStringExtra("Val2")
        val val3 = intent.getStringExtra("Val3")
        val nrChecks = intent.getIntExtra("NrChecks", 0)

        val gained: TextView = findViewById(R.id.textView)
        var score: Int = 0

        if ((val1 == "*" && val2 == "*" && val3 == "*") || (val1 == "*" && val2 == "*") || (val1 == "*" && val3 == "*") || (val2 == "*" && val3 == "*") ||
            (val1 == "*" && val2?.compareTo(val3.toString()) == 0) || (val2 == "*" && val1?.compareTo(val3.toString()) == 0) || (val3 == "*" && val1?.compareTo(val2.toString()) == 0) ||
            (val1?.compareTo(val2.toString()) == 0 && val2?.compareTo(val3.toString()) == 0)) {
            if (nrChecks == 0) {
                score = 100
                gained.text = "Gained " + score.toString()
            }
            else if (nrChecks == 1) {
                score = 50
                gained.text = "Gained " + score.toString()
            }
            else if (nrChecks == 2) {
                score = 10
                gained.text = "Gained " + score.toString()
            }
            else {
                score = 0
                gained.text = "Gained " + score.toString()
            }
        } else {
            gained.text = "Lost"
        }

        val button: Button = findViewById(R.id.backButton)

//        button.setOnClickListener {
//            val returnIntent = Intent().apply {
//                putExtra("another_key", "anotherValue")
//            }
//            setResult(RESULT_OK, returnIntent)
//            finish()
//        }
    }
}