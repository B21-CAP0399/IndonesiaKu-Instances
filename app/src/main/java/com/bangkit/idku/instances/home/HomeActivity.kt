package com.bangkit.idku.instances.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.idku.instances.databinding.ActivityHomeBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            viewModel.user?.apply {
                tvDisplayName.text = displayName ?: "NULL"
                tvInstanceName.text = email ?: "lol"
            }

            fabAdd.setOnClickListener {
                viewModel.addRequest(arrayListOf("ktp"))
            }
        }

    }

}