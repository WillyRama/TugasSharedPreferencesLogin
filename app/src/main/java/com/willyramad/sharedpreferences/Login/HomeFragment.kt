package com.willyramad.sharedpreferences.Login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.willyramad.sharedpreferences.R
import com.willyramad.sharedpreferences.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var spH : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentHomeBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spH =  requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        var ambilUser = spH.getString("Username","")
        binding.tvTampil.setText(" Hay Username $ambilUser")
        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            logOut()
        }
    }
    fun logOut(){
        spH.edit().clear()

    }
}