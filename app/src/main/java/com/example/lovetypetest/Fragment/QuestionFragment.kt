package com.example.lovetypetest.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetypetest.R
import kotlinx.android.synthetic.main.fragment_main.*

class QuestionFragment : Fragment(), View.OnClickListener{

    lateinit var navController: NavController //이따가 초기화하겠음
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        button_next.setOnClickListener(this) //this의 의미 :class파일에서 구현한 것을 쓰겠다
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button_next->{
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }


}