package com.example.rickandmortyhomeversion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyhomeversion.api.InterfaceApi
import com.example.rickandmortyhomeversion.api.RetrofitClient
import com.example.rickandmortyhomeversion.databinding.CharactersListBinding
import com.example.rickandmortyhomeversion.models.CharacterDataResponse
import com.example.rickandmortyhomeversion.models.ResultResponse
import timber.log.Timber

class CharacterListFragment : Fragment(), MainContract {

    private val api: InterfaceApi =
        RetrofitClient.getRetrofit().create(InterfaceApi::class.java)

    private val mainPresenter = MainPresenter(api)

    private val adapter: MainAdapter by lazy {
        MainAdapter(onClick = { showDetailsItem(it) })
    }

    private lateinit var binding: CharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharactersListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        mainPresenter.attach(this@CharacterListFragment)
        charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        charactersRecyclerView.adapter = adapter
        mainPresenter.getCharacterDataFromApi()
        Timber.i("Mama")
    }

    override fun showCharacters(data: CharacterDataResponse) {
        Timber.i(toString())
        adapter.setData(data.resultsResponse)

    }

    override fun dataFailure(t: Throwable) {
        Timber.e(t.message)
    }

    private fun showDetailsItem(resultResponse: ResultResponse) {
        val fragment = CharacterFragment()
        val bundle = Bundle()
        bundle.putSerializable("result", resultResponse)
        fragment.arguments = bundle
        replaceFragment (fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detach()
    }
}