package com.cs.apicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private lateinit var getEquation: EditText
    private lateinit var answerView: TextView
    private lateinit var equalButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getEquation = findViewById(R.id.equation)
        answerView = findViewById(R.id.answerView)
        equalButton = findViewById(R.id.equalbutton)
        val equation = getEquation.text
        val error = "ERROR in connection"
        val url = "https://api.mathjs.org/v4/?expr="
        val queue = Volley.newRequestQueue(this)
        equalButton.setOnClickListener {
            // convert the equation to url encoded
            val encodedURL = java.net.URLEncoder.encode(equation.toString(), "utf-8")
            val stringRequest = StringRequest(Request.Method.GET, url + encodedURL,
                { response ->
                    // Display the answer
                    answerView.text = response
                },
                {
                    answerView.text = error
                })
            queue.add(stringRequest)

        }

    }


}


