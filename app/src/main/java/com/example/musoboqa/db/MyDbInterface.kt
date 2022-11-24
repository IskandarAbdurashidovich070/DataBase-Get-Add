package com.example.musoboqa.db

import com.example.musoboqa.models.User

interface MyDbInterface {

    fun addContact(user: User)

    fun getContact() : List<User>

}