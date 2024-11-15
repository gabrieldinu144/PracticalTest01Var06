package ro.pub.cs.systems.eim.practicaltest01var06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06MainActivity : AppCompatActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playButton: Button = findViewById(R.id.play)
        val checkButton: Button = findViewById(R.id.check)

        val val1: EditText = findViewById(R.id.val1)
        val val2: EditText = findViewById(R.id.val2)
        val val3: EditText = findViewById(R.id.val3)

        val check1: CheckBox = findViewById(R.id.checkBox1)
        val check2: CheckBox = findViewById(R.id.checkBox2)
        val check3: CheckBox = findViewById(R.id.checkBox3)

        val texts = listOf("1", "2", "3", "*")
        var scor = 0

        playButton.setOnClickListener {
            if (!check1.isChecked)
                val1.setText(texts.random())
            if (!check2.isChecked)
                val2.setText(texts.random())
            if (!check3.isChecked)
                val3.setText(texts.random())

            Toast.makeText(this, "Val1: " + val1.text.toString() + "\nVal2: " + val2.text.toString() + "\nVal3: " + val3.text.toString(), Toast.LENGTH_SHORT).show()
        }

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Procesează rezultatul aici
                val data: Intent? = result.data
                val someData = data?.getStringExtra("another_key")
                // Folosește `someData` cum este necesar
            }
        }

        checkButton.setOnClickListener {
            var checks: Int = 0

            if (check1.isChecked)
                checks++
            if (check2.isChecked)
                checks++
            if (check3.isChecked)
                checks++

            val intent = Intent(this, PracticalTest01Var06SecondaryActivity::class.java)
            intent.putExtra("Val1", val1.text.toString())
            intent.putExtra("Val2", val2.text.toString())
            intent.putExtra("Val3", val3.text.toString())
            intent.putExtra("NrChecks", checks)
            startActivity(intent)
        }
    }


}