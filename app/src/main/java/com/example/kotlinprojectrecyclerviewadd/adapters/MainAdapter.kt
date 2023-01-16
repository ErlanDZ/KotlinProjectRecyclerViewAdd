package com.example.kotlinprojectrecyclerviewadd.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinprojectrecyclerviewadd.R
import com.example.kotlinprojectrecyclerviewadd.data.MainModal

class MainAdapter(private val listModal: MutableList<MainModal>)
    : RecyclerView.Adapter<MainAdapter.TextViewHolder>() {

    private val name: String = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent,false))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.onBind(listModal[position])
    }

    override fun getItemCount(): Int {
        return listModal.size
    }

    fun addNewItem(item : MainModal){
        listModal.add(item)
        notifyItemInserted(listModal.size - 1)
    }

    fun removeItem(position : Int){
        listModal.removeAt(position)
        notifyItemRemoved(position)
    }

   inner class TextViewHolder(view: View) : RecyclerView.ViewHolder(view){



        private var idTextMain: TextView? = null
        private var textMain: TextView? = null

        init {
            idTextMain = view.findViewById(R.id.id_text_main)
            textMain = view.findViewById(R.id.txt_text_main)
        }

        fun onBind(mainModal: MainModal) {

            textMain?.text = mainModal.name
        }



   }
}