package com.example.kotlinprojectrecyclerviewadd.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinprojectrecyclerviewadd.OnItemTextClickListener
import com.example.kotlinprojectrecyclerviewadd.R
import com.example.kotlinprojectrecyclerviewadd.data.MainModal

class TextAdapter(private val listModal: ArrayList<MainModal>,
                  private val onClickItemText: OnItemTextClickListener

) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {


    inner  class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var idTextMain: TextView? = null
        private var textMain: TextView? = null

        init {
            idTextMain = view.findViewById(R.id.id_text_main)
            textMain = view.findViewById(R.id.txt_text_main)
           // onClickItemText.onClick(adapterPosition,listModal[adapterPosition])
        }

        fun onBind(modal: MainModal) {
            textMain?.text = modal.name
            itemView.setOnClickListener {
                onClickItemText.onClick(adapterPosition,modal)
            }
        }

    }

    fun setData(position: Int, text : MainModal){
        listModal.add(position,text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent, false))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.onBind(listModal[position])
    }

    override fun getItemCount(): Int {
       return listModal.size
    }
}