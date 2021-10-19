package net.tc2r1.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import net.tc2r1.R
import net.tc2r1.data.network.RemoteDataSource
import net.tc2r1.data.network.Resource
import net.tc2r1.data.network.UserApi
import net.tc2r1.data.repository.UserRepository
import net.tc2r1.data.responses.User
import net.tc2r1.databinding.FragmentHomeBinding
import net.tc2r1.ui.handleApiError
import net.tc2r1.ui.logout
import net.tc2r1.ui.visible

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val remoteDataSource = RemoteDataSource()
        val api = remoteDataSource.buildApi(UserApi::class.java, requireContext())
        val userRepository = UserRepository(api)
        viewModel = HomeViewModel(userRepository)

        binding.progressbar.visible(false)
        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner){
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(it.value.user)
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        }

        binding.buttonLogout.setOnClickListener {
            logout()
        }
    }

    private fun updateUI(user: User) {
        with(binding) {
            textViewId.text = user.id.toString()
            textViewName.text = user.name
            textViewEmail.text = user.email
        }
    }
}