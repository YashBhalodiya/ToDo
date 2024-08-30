package com.yashbhalodiya.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class AddToDoFragment : Fragment() {

    private lateinit var todoField : EditText
    private lateinit var todoAddBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views using the provided view parameter
        todoField = view.findViewById(R.id.fragment_todo_field)
        todoAddBtn = view.findViewById(R.id.fragment_todo_addbtn)

        // Set an OnClickListener for the button
        todoAddBtn.setOnClickListener {
            val todoText = todoField.text.toString()
            if (todoText.isNotEmpty()) {
                val mainActivity = activity as? MainActivity
                mainActivity?.addTodoItem(todoText)
                parentFragmentManager.popBackStack() // Close the fragment and return to the previous one
            }
        }
    }
}