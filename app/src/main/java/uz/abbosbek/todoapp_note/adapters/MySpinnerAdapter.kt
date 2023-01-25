package uz.abbosbek.todoapp_note.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import uz.abbosbek.todoapp_note.databinding.SpinnerItemBinding
import uz.abbosbek.todoapp_note.models.SpinnerItem

class MySpinnerAdapter(val list:ArrayList<SpinnerItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: SpinnerItemBinding
        itemView=SpinnerItemBinding.inflate(LayoutInflater.from(parent?.context))

        if (list[position].image!=-1){
            itemView.spinnerImg.setImageResource(list[position].image)
        }
        itemView.spinnerTv.text=list[position].dagre

        return itemView.root
    }
}