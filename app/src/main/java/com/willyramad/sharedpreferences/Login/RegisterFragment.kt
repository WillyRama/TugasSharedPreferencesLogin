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
import com.willyramad.sharedpreferences.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    lateinit var spR : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spR = requireContext().getSharedPreferences("User", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
        Regis()
        }
        binding.backLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    fun Regis(){
        var Username = binding.EditUsername.text.toString()
        var Password = binding.EditPassword.text.toString()
        var NamaL = binding.EditNama.text.toString()
        var UlangPass = binding.EditUlangPass.text.toString()
        var aduser = spR.edit()
        aduser.putString("Username", Username)
        aduser.putString("Password", Password)
        aduser.putString("nama", NamaL)
        aduser.putString("passU", UlangPass)
        if (Password == UlangPass){
            aduser.apply()
            Toast.makeText(context, "Register Anda Telah Berhasil", Toast.LENGTH_SHORT).show()
            binding.EditUsername.setText("")
            binding.EditPassword.setText("")
            binding.EditNama.setText("")
            binding.EditUlangPass.setText("")
        }else{
            Toast.makeText(context, "Password anda tidak sama!!", Toast.LENGTH_SHORT).show()
        }
    }
    fun regisHilang(){
        spR.edit().clear()
    }
}