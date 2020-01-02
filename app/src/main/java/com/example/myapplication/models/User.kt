package com.example.myapplication.models
//в котлине переменные в классе не являются полями,
//а свойствами класса так как изначально в них есть геттер сеттер
public class User(name:String, email:String, pass:String, phone:String) {
    //ТАК КАК ГЕТТЕРЫ СЕТТЕРЫ ВСТРОЕНЫ ТО В НИХ ВСЕГД МОЖНО ВСТРОИТЬ НЬЮ УСЛОВИЯ!!!
    var name:String
    //по сути сеттер не обязательный так как мы не в интерпрайзе.
    //но лучше себя прививать чтобы в любой момент можно было написать условия
//         set(value) {
//            if (value.first() != 0.toChar())
//                field=value
//            }
     var email:String
     var pass:String
     var phone:String

    init {
        this.name = name
        this.email = email
        this.pass = pass
        this.phone = phone
    }

}