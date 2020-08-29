package com.example.lovetypetest.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetypetest.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)

        button_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){ //view가 null이아니면 가져오고, null이라면 null을 가져옴
            R.id.option_1 ->{navigateWithIndex(1)}
            R.id.option_2 ->{navigateWithIndex(2)}
            R.id.option_3 ->{navigateWithIndex(3)}
            R.id.option_4 ->{navigateWithIndex(4)}
            R.id.button_back->{
                navController.popBackStack()
            }

        }
    }

    fun navigateWithIndex(index : Int){
        val bundle= bundleOf("index" to index) // key, value
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }
}