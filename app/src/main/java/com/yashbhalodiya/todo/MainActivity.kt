package com.yashbhalodiya.todo

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var todoAdapter: ToDoAdapter
    private val todoList: MutableList<ToDoDataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = ToDoAdapter(todoList)
        recyclerView.adapter = todoAdapter

        val fabBtn : FloatingActionButton = findViewById(R.id.fabBtn)

        fabBtn.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.todo_container, AddToDoFragment())
                addToBackStack(null)
            }
        }
    }

    fun addTodoItem(todoText: String) {
        val todo = ToDoDataModel(todoText)
        todoList.add(todo)
        todoAdapter.notifyItemInserted(todoList.size - 1)
    }
}