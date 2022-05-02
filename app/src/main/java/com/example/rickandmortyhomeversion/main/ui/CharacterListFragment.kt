package com.example.rickandmortyhomeversion.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.common.basemvp.BaseFragmentMvp
import com.example.rickandmortyhomeversion.databinding.CharactersListBinding
import org.koin.android.ext.android.inject
import timber.log.Timber

class CharacterListFragment :
    BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.characters_list),
    MainContract.View {

    override val presenter: MainPresenter by inject()
    private val adapter: MainAdapter by lazy {
        MainAdapter(onClick = { showDetailsItem(it) })
    }

    private lateinit var binding: CharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = CharactersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun overrideEnterAnimation(animation: Int) {
        TODO("Not yet implemented")
    }

    override fun overrideExitAnimation(animation: Int) {
        TODO("Not yet implemented")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        charactersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        charactersRecyclerView.adapter = adapter
        presenter.getHeroList()
        Timber.i("${presenter.getHeroList()}")
    }

    private fun showDetailsItem(resultResponse: ResultResponse) {
        val fragment = CharacterFragment(R.layout.character)
        val bundle = Bundle()
        bundle.putSerializable("result", resultResponse)
        fragment.arguments = bundle
        changeFragment(fragment, R.id.fragmentContainer)
    }

    override fun showHeroList(data: CharacterDataResponse) {
        adapter.setData(data.resultsResponse)
    }

    override fun failure(t: Throwable) {
        Timber.e(t.message)
    }


}