package com.example.kotlinprojectrecyclerviewadd.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinprojectrecyclerviewadd.OnItemTextClickListener
import com.example.kotlinprojectrecyclerviewadd.R
import com.example.kotlinprojectrecyclerviewadd.TextRepository
import com.example.kotlinprojectrecyclerviewadd.adapters.TextAdapter
import com.example.kotlinprojectrecyclerviewadd.data.MainModal

class MainFragment : Fragment(), OnItemTextClickListener {

    private var rvText: RecyclerView? = null
    private var btnAdd : Button? = null
    private var mainModel: MainModal? = null
    private val textList =  ArrayList<MainModal>()
    private val textAdapter = TextAdapter(textList, this)
    private val repository = TextRepository()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvText = view.findViewById(R.id.recycler_view)
        btnAdd = view.findViewById(R.id.btn_add_text)
        initialize()
        getData()
    }




    private fun initialize() {
        textList.addAll(repository.getListOfCatHTTP())
        textAdapter.notifyDataSetChanged()
        rvText?.adapter = textAdapter
    }

    override fun onClick(position: Int, model: MainModal) {
        val bundle = Bundle()
        bundle.putString("input_txt", model.name)
        bundle.putInt("position", position)

        val frag2 = DetailFragment()
        frag2.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, frag2)
            .addToBackStack("null")
            .commit()
    }

    private fun getData() {
        val bundle = arguments
        mainModel = bundle?.getSerializable("input") as MainModal?
        val position = bundle?.getInt("editPosition")
        mainModel?.let {
            if (position != null) {
                textAdapter.setData(position,it)
            }
        }
    }
}