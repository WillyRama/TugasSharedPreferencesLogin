package com.willyramad.sharedpreferences.Login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.willyramad.sharedpreferences.R
import com.willyramad.sharedpreferences.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var spL : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spL = requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
           Login()
        }
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
    fun Login(){
        var ambilDataUser =  spL.getString("Username","")
        var ambilDataPas = spL.getString("Password", "")
        var user =  binding.EditUsername.text.toString()
        var password =  binding.EditPassword.text.toString()
        if (user.isEmpty()&& password.isEmpty()){
            Toast.makeText(context,"isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show()
        }else {
            if (user == ambilDataUser.toString() && password ==  ambilDataPas.toString()){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                Toast.makeText(context,"Anda Telah Login", Toast.LENGTH_SHORT).show()
            }else{
                if (user != ambilDataUser.toString() || password != ambilDataPas.toString()){
                    Toast.makeText(context, "Username dan Password Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}