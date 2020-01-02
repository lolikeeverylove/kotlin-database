package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.models.User
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.hobbies.*
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.material.snackbar.Snackbar


class HobbiesActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hobbies)

        //передаем инфу
        val arguments = intent.extras
        Log.d("transfer", arguments!!.get("hello")!!.toString())




        //从无到显示
        atpv_1.startAnimation(0f,1f)
        //从显示到消失
        stpv_2017.startAnimation(1f,0f);



        button4.setOnClickListener {
//            if(name.text.isEmpty()){
//                Snackbar.make( layoutVert, "Enter your name", Snackbar.LENGTH_SHORT).show()
//            }
            //        авторизация
            val auth = FirebaseAuth.getInstance()
            //        connect to db
            val con = FirebaseDatabase.getInstance()
            val users = con.getReference("Users")
            //for work with tables
            auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
                .addOnSuccessListener(OnSuccessListener {
                    val user: User = User(
                        name.text.toString(),
                        email.text.toString(),
                        pass.text.toString(),
                        phone.text.toString()
                    )
                    //задаем ключ и передаем  в бд!
                    users.child(FirebaseAuth.getInstance().currentUser!!.uid)
                        .setValue(user)
//                        .addOnFailureListener(OnFailureListener {  Snackbar.make(layoutVert, "User non  add ERROR!", Snackbar.LENGTH_SHORT).show()})
                        .addOnSuccessListener(OnSuccessListener { Snackbar.make(layoutVert, "User add", Snackbar.LENGTH_SHORT).show() })
                })
        }
    }
}