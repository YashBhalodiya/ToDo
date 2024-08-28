package com.yashbhalodiya.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(val todoList : MutableList<ToDoDataModel>) : RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val todoTextView : TextView = itemView.findViewById(R.id.todotxtview)
        val todoDeleteBtn : ImageButton = itemView.findViewById(R.id.tododeletebtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todoItem = todoList[position]
        holder.todoTextView.text = todoItem.title
        holder.todoDeleteBtn.setOnClickListener {
            todoList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, todoList.size)
        }
    }
}