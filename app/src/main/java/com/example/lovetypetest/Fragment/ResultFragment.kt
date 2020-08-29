package com.example.lovetypetest.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetypetest.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    var option = -1 // 넘어올 bundle을 잡아주기 위한 것것
    lateinit var navController: NavController
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        option=arguments?.getInt("index")?: -1 //=만약에 null이면 -1을 반환하겠다.


        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)

        setResult(option)

        home.setOnClickListener{
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option:Int){
        when(option){
            1->{
                tv_main.text="You are a QUITTER!" //==java의 settext
                tv_sub.text="You can let the person easily."
            }
            2->{
                tv_main.text="You should focus on yourself!" //==java의 settext
                tv_sub.text="You become really clingy to your ex."
            }
            3->{
                tv_main.text="You should take it easy" //==java의 settext
                tv_sub.text="You can do crazy things no matter what it takes."
            }
            4->{
                tv_main.text="You are pretty mature." //==java의 settext
                tv_sub.text="You can easily accept the break-up."
            }
        }
    }
}