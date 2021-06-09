package com.bangkit.idku.instances.request_result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.idku.instances.databinding.ActivityRequestPermissionResultBinding

class RequestPermissionResultActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRequestPermissionResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
//
//    private fun textToImageEncode(value: String){
//        val bitma
//    }

}