package com.rumeysaord.hesapmakinem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


import com.rumeysaord.hesapmakinem.R.id.*

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    var newOperator=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        val btnZero = findViewById<Button>(btn_Zero)
        val btnOne = findViewById<Button>(btn_One)
        val btnTwo = findViewById<Button>(btn_Two)
        val btnThree = findViewById<Button>(btn_Three)
        val btnFour = findViewById<Button>(btn_Four)
        val btnFive = findViewById<Button>(btn_Five)
        val btnSix = findViewById<Button>(btn_Six)
        val btnSeven = findViewById<Button>(btn_Seven)
        val btnEight = findViewById<Button>(btn_Eight)
        val btnNine = findViewById<Button>(btn_Nine)
        val btnSub = findViewById<Button>(btn_Sub)
        val btnDiv=findViewById<Button>(btn_Div)
        val btnMul=findViewById<Button>(btn_Mul)
        val btnSum=findViewById<Button>(btn_Sum)
        val btnAc=findViewById<Button>(btn_Clear)
        val btnPer=findViewById<Button>(btn_Per)
        val btnEqual=findViewById<Button>(btnEqual)
        val butonAE =  findViewById<Button>(btnArtiEksi)
        val btnPoint=findViewById<Button>(btn_point)



        fun btn_Click(view: View){
        if (newOperator){
            editText.setText("")
        }
        newOperator=false
        val btnSelect = view as Button
        var btnClickValue:String =  editText.text.toString()
        when(btnSelect.id){
            btn_Zero->{
                btnClickValue+="0"
            }
            btn_One ->{
                btnClickValue+="1"
            }
            btn_Two->{
                btnClickValue+="2"
            }
            btn_Three->{
                btnClickValue+="3"
            }
            btn_Four->{
                btnClickValue+="4"
            }
           btn_Five->{
                btnClickValue+="5"
            }
            btn_Six->{
                btnClickValue+="6"
            }
           btn_Seven->{
                btnClickValue+="7"
            }
           btn_Eight->{
                btnClickValue+="8"
            }
           btn_Nine->{
                btnClickValue+="9"
            }
          btnArtiEksi->{
              btnClickValue = when {
                  btnClickValue.startsWith("-") -> btnClickValue.substring(1)
                  btnClickValue.startsWith("+") -> "-" + btnClickValue.substring(1)
                  else -> "-" + btnClickValue
              }
          }

            btn_point->{
                btnClickValue=btnClickValue + "."
            }
        }
        editText.setText(btnClickValue)
    }
        btnPoint.setOnClickListener { btn_Click(it) }
        butonAE.setOnClickListener { btn_Click(it) }
        btnZero.setOnClickListener { btn_Click(it) }
        btnOne.setOnClickListener { btn_Click(it) }
        btnTwo.setOnClickListener { btn_Click(it) }
        btnThree.setOnClickListener { btn_Click(it) }
        btnFour.setOnClickListener{btn_Click(it)}
        btnFive.setOnClickListener{btn_Click(it)}
        btnSix.setOnClickListener{btn_Click(it)}
        btnSeven.setOnClickListener{btn_Click(it)}
        btnEight.setOnClickListener{btn_Click(it)}
        btnNine.setOnClickListener{btn_Click(it)}
        var oldCount = ""
        var operator = "*"
        fun btn_Operator(view: View) {

            if (editText != null) {
                val btn_Select = view as Button
                when (btn_Select.id) {
                   btn_Div -> {
                        operator = "/"
                    }
                   btn_Mul -> {
                        operator = "*"
                    }
                    btn_Sub -> {
                        operator = "-"
                    }
                  btn_Sum -> {
                       operator = "+"
                    }
                }
                oldCount = editText.text.toString()
                newOperator = true
            }
        }
        fun btn_Equal() {

            var result:Double?=null
            val newCount = editText.text.toString()

            when(operator){
                "/"->{
                    result= oldCount.toDouble()/newCount.toDouble()
                }
                "*"->{
                    result= oldCount.toDouble()*newCount.toDouble()
                }
                "-"->{
                    result= oldCount.toDouble()-newCount.toDouble()
                }
                "+"->{
                    result=oldCount.toDouble()+newCount.toDouble()
                }
            }


            editText.setText(result.toString())
            newOperator =true

        }
        btnEqual.setOnClickListener { btn_Equal() }
        btnSub.setOnClickListener { btn_Operator(it) }
        btnDiv.setOnClickListener { btn_Operator(it) }
        btnMul.setOnClickListener { btn_Operator(it) }
        btnSum.setOnClickListener { btn_Operator(it) }
        fun btn_Ac() {
            editText.setText("0")
            newOperator =true
        }
        btnAc.setOnClickListener { btn_Ac() }
        fun btn_Per() {

            val count:Double=editText.text.toString().toDouble()/100
          editText.setText(count.toString())
            newOperator =true
        }
        btnPer.setOnClickListener { btn_Per() }
}}
