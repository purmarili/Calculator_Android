package ge.jvash.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View) {
        if (clickedView is Button) {
            val number = clickedView.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0")
                result = ""
            resultTextView.text = result + number

        }


    }

    fun operationClick(clickedView: View) {
        if (clickedView is Button) {
            var resultText = resultTextView.text.toString()
            if (resultText.isEmpty())
                return
            operand = resultText.toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = ""

        }
    }

    fun equalsClick(clickedView: View) {
        val resultText = resultTextView.text.toString()
        if (resultText.isEmpty())
            return
        val secondOperand = resultText.toDouble()

        when (operation) {
            "+" -> resultTextView.text = (operand + secondOperand).toString()
            "-" -> resultTextView.text = (operand - secondOperand).toString()
            "*" -> resultTextView.text = (operand * secondOperand).toString()
            "/" -> resultTextView.text = (operand / secondOperand).toString()
        }

        val curr = resultTextView.text.toString()
        val ind = curr.indexOf('.')
        if (ind != -1)
            if ((curr.substring(ind + 1).filter { it != '0' }).isEmpty())
                resultTextView.text = curr.substring(0, ind)
        operation = ""
        operand = resultText.toDouble()
    }


    fun deleteClick(clickedView: View) {
        var resultText = resultTextView.text.toString()
        if (resultText.isEmpty())
            return
        resultTextView.text = resultText.dropLast(1)
    }

}