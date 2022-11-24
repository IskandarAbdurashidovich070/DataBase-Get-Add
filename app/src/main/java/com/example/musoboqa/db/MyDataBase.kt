package com.example.musoboqa.db

import com.example.musoboqa.models.User


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, "my_contact_db", null, 1),
    MyDbInterface{

    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "create table my_contacts (id integer not null primary key autoincrement unique, name text not null, number text not null )"
        p0?.execSQL(query)    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    override fun addContact(user: User) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name", user.name)
        contentValues.put("number", user.number)
        database.insert("my_contacts", null, contentValues)
        database.close()    }

    override fun getContact(): List<User> {
        val list =  ArrayList<User>()
        val database = readableDatabase
        val query = "select * from my_contacts"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()){
            do {
                val myContact = User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
                )
                list.add(myContact)
            }while (cursor.moveToNext())
        }
        return list

    }


}
























