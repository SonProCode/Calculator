package com.example.newcalculator_constraint

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.res)

        findViewById<Button>(R.id.but0).setOnClickListener(this)
        findViewById<Button>(R.id.but1).setOnClickListener(this)
        findViewById<Button>(R.id.but2).setOnClickListener(this)
        findViewById<Button>(R.id.but3).setOnClickListener(this)
        findViewById<Button>(R.id.but4).setOnClickListener(this)
        findViewById<Button>(R.id.but5).setOnClickListener(this)
        findViewById<Button>(R.id.but6).setOnClickListener(this)
        findViewById<Button>(R.id.but7).setOnClickListener(this)
        findViewById<Button>(R.id.but8).setOnClickListener(this)
        findViewById<Button>(R.id.but9).setOnClickListener(this)
        findViewById<Button>(R.id.add).setOnClickListener(this)
        findViewById<Button>(R.id.min).setOnClickListener(this)
        findViewById<Button>(R.id.mul).setOnClickListener(this)
        findViewById<Button>(R.id.div).setOnClickListener(this)
        findViewById<Button>(R.id.cbut).setOnClickListener(this)
        findViewById<Button>(R.id.CE).setOnClickListener(this)
        findViewById<Button>(R.id.addMin).setOnClickListener(this)
        findViewById<Button>(R.id.equal).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.but0) {
            addDigit(0)
        } else if (id == R.id.but1) {
            addDigit(1)
        } else if (id == R.id.but2) {
            addDigit(2)
        } else if (id == R.id.but3) {
            addDigit(3)
        }
        else if (id == R.id.but4) {
            addDigit(4)
        }
        else if (id == R.id.but5) {
            addDigit(5)
        }
        else if (id == R.id.but6) {
            addDigit(6)
        }
        else if (id == R.id.but7) {
            addDigit(7)
        }
        else if (id == R.id.but8) {
            addDigit(8)
        }
        else if (id == R.id.but9) {
            addDigit(9)
        }
        else if (id == R.id.add) {
            op = 1
            state = 2
        }
        else if (id == R.id.min) {
            op = 2
            state = 2
        }
        else if (id == R.id.mul) {
            op = 3
            state = 2
        }else if (id == R.id.div) {
            op = 4
            state = 2
        }
        else if (id == R.id.addMin) {
            doiDau()
        }
        else if (id == R.id.CE) {
            if (state == 1)
                op1 = 0
            else
                op2 = 0;
            textReuslt.text = "0"
        }
        else if (id == R.id.cbut) {
            textReuslt.text = "0"
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        }
        else if (id == R.id.equal) {
            var result = 0
            if (op == 1) {
                result = op1 + op2
            }
            if (op == 2) {
                result = op1 - op2
            }
            if (op == 3) {
                result = op1 * op2
            }
            if (op == 4) {
                result = op1 / op2
            }
            textReuslt.text = "$result"
            state = 1
            op1 = result
            op2 = 0
            op = 0
        }

    }
    fun doiDau(){
        if (state == 1) {
            op1 = -op1
            textReuslt.text = "$op1"
        } else {
            op2 = -op2
            textReuslt.text = "$op2"
        }
    }
    fun addDigit(c: Int) {
        var dau = 0
        if (state == 1) {

            if (op1 < 0) {
                op1 = -op1;
                dau = 1
            }
            op1 = op1 * 10 + c
            if (dau == 1)
                op1 = -op1
            textReuslt.text = "$op1"
        } else {
            if (op2 < 0) {
                op2 = -op2;
                dau = 1;
            }
            op2 = op2 * 10 + c
            if (dau == 1)
                op2 = -op2
            textReuslt.text = "$op2"
        }
    }
}