package uz.abbosbek.todoapp_note.models

data class Todo(
    var name:String="",
    var description:String="",
    var degree:String="",
    var degreePicture: String="",
    var createDate:String="",
    var deadline:String="",
    var checkboxId: String=""
)
