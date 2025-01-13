package com.ricardo.workshop.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardo.workshop.android.R
import com.ricardo.workshop.android.data.LocalDataSource

internal class ToastListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ToastListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        val toastAdapter = ToastAdapter()
        recyclerView.adapter = toastAdapter
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        ).apply {
            setDrawable(ContextCompat.getDrawable(recyclerView.context, R.drawable.divider)!!)
        }
        recyclerView.addItemDecoration(dividerItemDecoration)

        LocalDataSource().getToasts().also {
            toastAdapter.submitList(it)
        }

    }


}