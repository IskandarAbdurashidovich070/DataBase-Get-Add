package com.example.musoboqa.models

class User {
    var id: Int = 0
    var name: String = ""
    var number: String = ""

    constructor(id: Int, name: String, number: String) {
        this.id = id
        this.name = name
        this.number = number
    }

    constructor(name: String, number: String) {
        this.name = name
        this.number = number
    }


}