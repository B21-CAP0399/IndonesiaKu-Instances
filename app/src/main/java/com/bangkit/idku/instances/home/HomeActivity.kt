package com.bangkit.idku.instances.home

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.idku.instances.databinding.ActivityHomeBinding
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
        supportActionBar?.title = "Home"
        with(binding) {
            viewModel.user?.apply {
                tvDisplayName.text = displayName ?: "NULL"
                tvInstanceName.text = email ?: "lol"
            }

            fabAdd.setOnClickListener {
                viewModel.addRequest(arrayListOf("ktp"))
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@HomeActivity, task.result.toString(), LENGTH_SHORT)
                                .show()
                        } else {
                            Timber.e("error ")
                        }
                    }
            }
        }

    }

}