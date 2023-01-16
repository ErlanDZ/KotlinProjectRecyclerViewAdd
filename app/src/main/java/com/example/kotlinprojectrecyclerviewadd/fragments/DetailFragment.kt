package com.example.kotlinprojectrecyclerviewadd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.kotlinprojectrecyclerviewadd.R
import com.example.kotlinprojectrecyclerviewadd.data.MainModal

class DetailFragment : Fragment() {

    private var editText : EditText? = null
    private var btn: Button? = null
    private var textModel: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.edit_detail)
        btn = view.findViewById(R.id.btn_to_main_fragment)


        btn?.setOnClickListener {
            val text : String = editText?.text.toString()
            val bundle = Bundle()
            bundle.putSerializable("input", MainModal(text))
            arguments?.getInt("position")?.let { position ->
                bundle.putInt("editPosition", position)
            }

            val frag1 = MainFragment()
            frag1.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, frag1)
                .addToBackStack("null")
                .commit()
        }

        getData()
    }

    private fun getData() {
        val bundle = arguments
        textModel = bundle?.getString("input_txt")
        textModel?.let {
            editText?.setText(it)
        }
    }

}