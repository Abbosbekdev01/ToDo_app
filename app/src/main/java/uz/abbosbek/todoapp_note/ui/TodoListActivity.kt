package uz.abbosbek.todoapp_note.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.abbosbek.todoapp_note.adapters.MyExpandibleAdapter
import uz.abbosbek.todoapp_note.catch.MySharedPreference
import uz.abbosbek.todoapp_note.databinding.ActivityTodoListBinding
import uz.abbosbek.todoapp_note.models.Todo
import uz.abbosbek.todoapp_note.models.TodoList

class TodoListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoListBinding
    lateinit var map: HashMap<String,ArrayList<Todo>>
    lateinit var groupList:ArrayList<String>
    lateinit var myExpandibleAdapter: MyExpandibleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.apply {

            groupList= ArrayList()

            groupList.add("Open")
            val openList=ArrayList<Todo>()
            groupList.add("Development")
            val developmentList=ArrayList<Todo>()
            groupList.add("Uploading")
            val uploadingList=ArrayList<Todo>()
            groupList.add("Reject")
            val rejectList=ArrayList<Todo>()
            groupList.add("Closed")
            val closedList=ArrayList<Todo>()

            MySharedPreference.init(this@TodoListActivity)
            TodoList.todoList=MySharedPreference.catchList


            TodoList.todoList.forEach {
                when(it.checkboxId){
                    "0"->openList.add(it)
                    "1"->developmentList.add(it)
                    "2"->uploadingList.add(it)
                    "3"->rejectList.add(it)
                    "4"->closedList.add(it)
                }
            }

            map= HashMap()
            map[groupList[0]]=openList
            map[groupList[1]]=developmentList
            map[groupList[2]]=uploadingList
            map[groupList[3]]=rejectList
            map[groupList[4]]=closedList

            myExpandibleAdapter= MyExpandibleAdapter(map, groupList)
            expendibleLv.setAdapter(myExpandibleAdapter)


            val intent= Intent(this@TodoListActivity, InfoActivity::class.java)
            expendibleLv.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                intent.putExtra("name", map[groupList[groupPosition]]?.get(childPosition)?.name)

                startActivity(intent)
                true}
        }

    }

}