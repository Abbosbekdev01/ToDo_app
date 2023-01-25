package uz.abbosbek.todoapp_note.catch

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.abbosbek.todoapp_note.models.Todo

object MySharedPreference {
    private const val NAME = "Cache"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var catchList: ArrayList<Todo>
        get() = gsonStringToArray(preferences.getString("key", "[]")!!)
        set(value) = preferences.edit {
            it.putString("key", arrayToGsonString(value))
        }

    fun arrayToGsonString(arrayList: ArrayList<Todo>): String {
        return Gson().toJson(arrayList)
    }

    fun gsonStringToArray(gsonString: String): ArrayList<Todo> {
        val typeToken = object : TypeToken<ArrayList<Todo>>() {}.type
        return Gson().fromJson(gsonString, typeToken)
    }
}