package com.willyramad.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.willyramad.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPrefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("STUDENT", Context.MODE_PRIVATE)
        binding.saveSatu.setOnClickListener{
            saveData()
            Toast.makeText(this,"Data verhasil disimpan", Toast.LENGTH_SHORT).show()
        }
        binding.saveDua.setOnClickListener{
         viewData()
        }
        binding.saveTiga.setOnClickListener{
            ClearData()
        }
    }
    fun saveData(){
        var getNim = binding.TvNim.text.toString()
        var getNama = binding.TvNama.text.toString()

        var edData = sharedPrefs.edit()
        edData.putString("nim", getNim)
        edData.putString("nama", getNama)
        edData.apply()
    }
    fun viewData(){
        binding.textnama.text = "Nama :" + sharedPrefs.getString("nama", "")
        binding.textnim.text = "Nim :" + sharedPrefs.getString("nim","")

    }
    fun ClearData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()

        binding.TvNim.setText("")
        binding.TvNama.setText("")
    }
}