package com.yashbhalodiya.todo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var todoAdapter: ToDoAdapter
    private val todoList: MutableList<ToDoDataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = ToDoAdapter(todoList)
        recyclerView.adapter = todoAdapter

        val addBtn : ImageButton = findViewById(R.id.addbtn)
        val todoField : EditText = findViewById(R.id.todofield)

        addBtn.setOnClickListener {
            val todoTxt = todoField.text.toString()
            val todo = ToDoDataModel(todoTxt)
            todoList.add(todo)
            todoAdapter.notifyItemInserted(todoList.size - 1)
            todoField.text.clear()
        }

    }
}