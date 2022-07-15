package com.mrmansur.singleactivityapplication.fragment.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrmansur.singleactivityapplication.R
import com.mrmansur.singleactivityapplication.adapter.PostAdapter
import com.mrmansur.singleactivityapplication.databinding.FragmentHomeBinding
import com.mrmansur.singleactivityapplication.extension.activityNavController
import com.mrmansur.singleactivityapplication.extension.navigateSafely
import com.mrmansur.singleactivityapplication.manager.AuthManager
import com.mrmansur.singleactivityapplication.model.Post
import com.mrmansur.singleactivityapplication.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home){
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var adapter: PostAdapter
    private lateinit var posts : ArrayList<Post>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        posts = ArrayList()
        initViews()
    }

    private fun initViews() {
        RetrofitBuilder.POST_SERVICE.allPosts().enqueue(object : Callback<ArrayList<Post>>{
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                if (response.isSuccessful){
                    refreshAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }

    private fun refreshAdapter(list : ArrayList<Post>){
        adapter = PostAdapter(list)
        binding.rvHome.adapter = adapter
    }

}