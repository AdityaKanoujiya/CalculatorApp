package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var txthistory: TextView
    lateinit var txtcurrent: TextView
    lateinit var btn0: TextView
    lateinit var btn1: TextView
    lateinit var btn2: TextView
    lateinit var btn3: TextView
    lateinit var btn4: TextView
    lateinit var btn5: TextView
    lateinit var btn6: TextView
    lateinit var btn7: TextView
    lateinit var btn8: TextView
    lateinit var btn9: TextView
    lateinit var btndoublezero: TextView
    lateinit var btnadd: TextView
    lateinit var btnsub: TextView
    lateinit var btnmult: TextView
    lateinit var btnmod: TextView
    lateinit var btnback: TextView
    lateinit var btnclear: TextView
    lateinit var btnequal: TextView
    lateinit var btndiv: TextView


    var num=0
    var signs:Char='&'
    var str=""
    var total1=0
    var curr=0
    var num1:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txthistory=findViewById(R.id.txthistory)
         txtcurrent=findViewById(R.id.txtcurrent)
         btn1=findViewById(R.id.btn1)
         btn2=findViewById(R.id.btn2)
         btn3=findViewById(R.id.btn3)
         btn4=findViewById(R.id.btn4)
         btn5=findViewById(R.id.btn5)
         btn6=findViewById(R.id.btn6)
         btn7=findViewById(R.id.btn7)
         btn8=findViewById(R.id.btn8)
         btn9=findViewById(R.id.btn9)
         btn0=findViewById(R.id.btn0)
        btndoublezero=findViewById(R.id.btndoublezero)
         btnclear =findViewById(R.id.btnclear)
        btnback=findViewById(R.id.btnback)
        btnadd =findViewById(R.id.btnadd)
        btnsub =findViewById(R.id.btnsubtract)
         btnmult=findViewById(R.id.btnmultiply)
        btndiv =findViewById(R.id.btndivide)
         btnmod =findViewById(R.id.btnmodulus)
        btnequal =findViewById(R.id.btnequal)


        btnadd.setOnClickListener(){
            emptycheck()
            checksign()
            total1=total(signs,total1,curr)
            curr=0
            signs='+'
            str="${txtcurrent.text}${signs.toString()}"
            txtcurrent.setText(str)
        }
        btnsub.setOnClickListener(){
            emptycheck()
            checksign()
            //total1=total(signs,total1,curr)
            curr=0
            signs='-'
            txtcurrent.setText("${txtcurrent.text}${signs.toString()}")
        }
        btnmult.setOnClickListener(){
            emptycheck()
            checksign()
            total1=total(signs,total1,curr)
            curr=0
            signs='*'
            txtcurrent.setText("${txtcurrent.text}${signs.toString()}")
        }
        btndiv.setOnClickListener(){
            emptycheck()
            checksign()
            total1=total(signs,total1,curr)
            curr=0
            signs='/'
            txtcurrent.setText("${txtcurrent.text}${signs.toString()}")
        }
        btnmod.setOnClickListener(){
            emptycheck()
            checksign()
            total1=total(signs,total1,curr)
            curr=0
            signs='%'
            txtcurrent.setText("${txtcurrent.text}${signs.toString()}")
        }
        btnequal.setOnClickListener(){
            total1=total(signs,total1,curr)
            signs='='
            curr=0
            txthistory.setText(txtcurrent.text)
            txtcurrent.setText(total1.toString())
        }

        btnclear.setOnClickListener(){
            txtcurrent.setText("")
            txthistory.setText("")
            signs='='
            total1=0
            curr=0

        }
        btnback.setOnClickListener(){
//            str=((txtcurrent.text).last().toString())
//            if(str=="+" || str=="-" || str=="*" || str=="/" || str=="%" ){
//                txtcurrent.setText((txtcurrent.text).dropLast(1))
//            }
            txtcurrent.setText((txtcurrent.text).dropLast(1))
            curr/=10
        }

        btndoublezero.setOnClickListener() {
            if (txtcurrent.text.length == 0) {
                    curr=0
                str = "${txtcurrent.text}0"
                txtcurrent.setText(str.toString())
            } else {
                curr = curr * 100
                str = "${txtcurrent.text}00"
                txtcurrent.setText(str.toString())
            }
        }

        btn1.setOnClickListener(){
            checkzero()
            num=1
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn2.setOnClickListener(){
            num=2
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn3.setOnClickListener(){
            num=3
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn4.setOnClickListener(){
            num=4
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn5.setOnClickListener(){
            num=5
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn6.setOnClickListener(){
            num=6
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn7.setOnClickListener(){
            num=7
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn8.setOnClickListener(){
            num=8
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn9.setOnClickListener(){
            num=9
            checkzero()
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }
        btn0.setOnClickListener(){
            num=0
            str="${txtcurrent.text}${num.toString()}"
            curr = (curr*10)+num
            txtcurrent.setText(str.toString())
        }

    }
    fun emptycheck(){   //to prevent from crash
        if(txtcurrent.text.toString()==""){
            txtcurrent.setText("0")
        }
    }
    fun total(signs:Char, total1:Int,curr:Int):Int{

        when(signs) {
            '+' -> return total1 + curr
            '-' -> return total1 - curr
            '*' -> {
                var total=total1
                if(total==0){
                    return 1*curr
                }
                else{
                    return total * curr
                }
            }
            '/' ->
            {
                if(total1==0){
                    return 1/curr
                }
                else if(curr==0){
                    return total1/1
                }
                else{
                    return (total1 / curr)
                }

            }
            '%' -> return total1 % curr
            '='-> {
                  var res: Int =txtcurrent.text.toString().toInt()
                return res
            }
            else -> return curr
        }

    }

    fun checkzero(){
        if(txtcurrent.text.length==1){
            str=(txtcurrent.text).first().toString()
            if(str=="0"){
                txtcurrent.setText((txtcurrent.text).dropLast(1))
            }
        }

    }

    fun checksign(){
        str=((txtcurrent.text).last().toString())
        if(str=="+" || str=="-" || str=="*" || str=="/" || str=="%" ){
            txtcurrent.setText((txtcurrent.text).dropLast(1))
        }
    }

}