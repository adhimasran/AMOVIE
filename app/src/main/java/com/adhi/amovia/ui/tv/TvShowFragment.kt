package com.adhi.amovia.ui.tv

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.adhi.amovia.data.source.local.entity.TvEntity
import com.adhi.amovia.databinding.FragmentTvShowBinding
import com.adhi.amovia.ui.detail.DetailTvActivity
import com.adhi.amovia.utils.Utility.loading
import com.adhi.amovia.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var adapter: TvAdapter
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding
    private val viewModelFactory = ViewModelFactory.getInstance()
    private val viewModel: TvShowViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            viewModel.getTvShows().observe(viewLifecycleOwner, {
                if (it != null) {
                    binding?.progressBar?.loading(false)
                    adapter.setTv(it)
                }
            })
            adapter = TvAdapter()


            with(binding?.rvTvShow) {
                if (context?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    this?.layoutManager = GridLayoutManager(context, 4)
                } else {
                    this?.layoutManager = GridLayoutManager(context, 2)
                }
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }

            adapter.setOnItemClickCallback(object : TvAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TvEntity) = showDetail(data)
            })
        }

        binding?.progressBar?.loading(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDetail(data: TvEntity) {
        val intent = Intent(context, DetailTvActivity::class.java)
        intent.putExtra(DetailTvActivity.EXTRA_TV, data.id)
        startActivity(intent)
    }
}