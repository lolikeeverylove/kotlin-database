package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.rengwuxian.materialedittext.MaterialEditText
import kotlinx.android.synthetic.main.hobbies.*
import kotlinx.android.synthetic.main.register.*


//toast всплывающее сообщение внизу
//Snackbar выскакивающий внизу месседж
//!! говорит что нужны null pointer exception
/*
numbers.filter({ x -> x.isPrime() })
numbers.filter { x -> x.isPrime() } // всё равно друг другу!!
numbers.filter { it.isPrime() }
 */
/*если используем лате инит то обязуемся позже обьявить переменную. она не нулл но и ты обязан определить!!!
и его нельзя с примитивными типами так как проверка на нул в гетере
 */

class MainActivity : AppCompatActivity() {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transferBut.setOnClickListener{
            transferIntent()
        }
//        Log.d("PASS", pass.text.toString())
        registerBut.setOnClickListener {
//            dialogOpen()
        }

        randomBut.setOnClickListener {
            kekan(2,1)
            collection()
            toast()

        }
    }

    fun kekan(a:Int,b:Int):Int{
        return if(a>b)a+b else b
    }

    fun toast(){
        Toast.makeText(this, kekan(5,4).toString()+" hui moch",Toast.LENGTH_SHORT).show()
    }

    fun collection(){
        val a = mutableListOf<Int>(1,24,5)
        Log.d("List", a.filter{a.get(1) % 2==0}.toString())
        val b = hashMapOf<String, String>("First" to "hui", "Second" to "double hui", "Third" to "trieple hui")
        for (iter in b){
            Log.d("Hash", iter.toString())
        }
    }

    fun transferIntent() {
        val intent = Intent (this,HobbiesActivity::class.java)
        // передача объекта с ключом "hello" и значением "Hello World"
        intent.putExtra("hello", "Hello World")
        startActivity(intent)
    }



//не работает потому что все нулл и не вызывается почему то!!



//    fun dialogOpen(){
//        val dialog= AlertDialog.Builder(this)
//        dialog.setTitle("Register new user")
//        dialog.setMessage("")
//        val inflater= LayoutInflater.from(this)
//        val register_window = inflater.inflate(R.layout.register,null)
//        dialog.setView(register_window)
//        dialog.setPositiveButton("dasda", DialogInterface.OnClickListener(){
//                dialog, which ->
////            Log.d("Email",  email.text.toString())
//
////            Log.d("Name",  name.text.toString())
////            if(pass.text.toString() == null && pass.text.toString().isEmpty() && pass.text.toString().equals("null")) {
//            if(pass.text.toString().length==0){
//            Log.d("Pass","pass is null")}
//
////            else Log.d("Pass",  pass.text.toString())
////            Log.d("Number",  phone.text.toString())
//        })
//        dialog.setNegativeButton("CANCEL", DialogInterface.OnClickListener(){
//            dialog: DialogInterface , which: Int -> dialog.dismiss()
//        })
//        dialog.setNeutralButton("Add", DialogInterface.OnClickListener() { dialog: DialogInterface?, _ ->
////            if (name.text.toString() == null) {
////                Snackbar.make(layoutConst, "Enter your name", Snackbar.LENGTH_SHORT).show()
////            } else{
//            //        авторизация
//            val auth = FirebaseAuth.getInstance()
//            //        connect to db
//            val con = FirebaseDatabase.getInstance()
//            val users = con.getReference("Users")
//            //for work with tables
//            auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
//                .addOnSuccessListener(OnSuccessListener {
//                    val user: User = User(
//                        name = name.text.toString(),
//                        email = email.text.toString(),
//                        pass = pass.text.toString(),
//                        phone = phone.text.toString()
//                    )
//                    //задаем ключ и передаем  в бд!
//                    users.child(FirebaseAuth.getInstance().currentUser!!.uid)
//                        .setValue(user)
//                        .addOnSuccessListener(OnSuccessListener {
//                            Snackbar.make(
//                                layoutVert,
//                                "User add succesful(успешно)",
//                                Snackbar.LENGTH_SHORT
//                            )
//                        })
//                })
////        }
//        })
//
//        dialog.show()
//    }
}