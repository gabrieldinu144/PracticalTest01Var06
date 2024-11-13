package ro.pub.cs.systems.eim.practicaltest01var06

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.play)
        val val1: EditText = findViewById(R.id.val1)
        val val2: EditText = findViewById(R.id.val2)
        val val3: EditText = findViewById(R.id.val3)

        val check1: CheckBox = findViewById(R.id.checkBox1)
        val check2: CheckBox = findViewById(R.id.checkBox2)
        val check3: CheckBox = findViewById(R.id.checkBox3)

        val texts = listOf("1", "2", "3", "*")

        button.setOnClickListener {
            if (!check1.isChecked)
                val1.setText(texts.random())
            if (!check2.isChecked)
                val2.setText(texts.random())
            if (!check3.isChecked)
                val3.setText(texts.random())
        }
    }


}