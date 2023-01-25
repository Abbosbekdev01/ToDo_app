package uz.abbosbek.todoapp_note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.abbosbek.todoapp_note.databinding.ActivityMainBinding
import uz.abbosbek.todoapp_note.ui.TodoListActivity
import uz.abbosbek.todoapp_note.ui.AddTodo as AddTodo1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this, TodoListActivity::class.java))
        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(this, AddTodo1::class.java))
        }
    }
}