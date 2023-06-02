package com.example.myapplication

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listarClientes : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: FloatingActionButton
    lateinit var dbh: DBhelper
    private lateinit var newArray: ArrayList<Datalist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_clientes)

        recyclerView = findViewById(R.id.lista)

        dbh = DBhelper(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        displayuser()

    }

    private fun displayuser() {
        var newcursor: Cursor? = dbh!!.GetText()
        newArray = ArrayList<Datalist>()
        while (newcursor!!.moveToNext()){
            val uemail = newcursor.getString(0)
            val usenha = newcursor.getString(1)
            newArray.add(Datalist(uemail, usenha))
        }
        recyclerView.adapter = MyAdapter(newArray)
    }
}