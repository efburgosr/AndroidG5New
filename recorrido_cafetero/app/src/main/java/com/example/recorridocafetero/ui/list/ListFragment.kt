package com.example.recorridocafetero.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recorridocafetero.databinding.FragmentListBinding
import com.example.recorridocafetero.model.Lugar
import com.example.recorridocafetero.model.LugarItem
import com.google.gson.Gson



class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugaresAdapter: LugaresAdapter
    private var listLugares: ArrayList<LugarItem> = arrayListOf()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup ?,
        savedInstanceState: Bundle?
    ): View {

        listBinding= FragmentListBinding.inflate(inflater, container, false)
        listViewModel= ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //listViewModel.loadMockLugaresFromJson(context?.assets?.open("lugares.json"))

        listViewModel.getLugaresFromServer()

        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner,{ result ->
            onLugaresLoadedSubscribe(result)

        })

        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = { onLugarClicked (it) })

        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugaresLoadedSubscribe(result: ArrayList<LugarItem>?) {
        result?.let {  listLugares ->
            lugaresAdapter.appendItems(listLugares)

        }


    }

    private fun onLugarClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment2(lugar= lugar))
    }


}