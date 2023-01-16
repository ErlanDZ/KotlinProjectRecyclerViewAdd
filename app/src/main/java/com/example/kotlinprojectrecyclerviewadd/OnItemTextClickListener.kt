package com.example.kotlinprojectrecyclerviewadd

import com.example.kotlinprojectrecyclerviewadd.data.MainModal

interface OnItemTextClickListener {
    fun onClick(position: Int, model: MainModal)
}