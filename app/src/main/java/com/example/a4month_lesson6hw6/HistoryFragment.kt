package com.example.a4month_lesson6hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a4month_lesson6hw6.databinding.FragmentHistoryBinding
import com.example.a4month_lesson6hw6.databinding.FragmentResultBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.appDatabase.loveDao().getAll()
        var data = ""

        list.forEach {
            data += "${it.firstName}\n${it.secondName}\n${it.percentage}\n\n"
        }
        binding.resultTv.text = data

    }
}