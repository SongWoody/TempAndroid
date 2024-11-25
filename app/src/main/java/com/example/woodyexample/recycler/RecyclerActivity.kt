package com.example.woodyexample.recycler

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.woodyexample.R
import com.example.woodyexample.databinding.ActivityRecyclerBinding

class RecyclerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private val tag = "RecyclerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initializeRecyclerView()
    }

    fun initializeRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerAdapter(
            listOf(
                User("name", "age"),
                User("name", "age")
            ),
            onClickListener = { user ->
                // 클릭 이벤트 처리
                Log.i(tag, "user: $user")
            }
        )
    }
}