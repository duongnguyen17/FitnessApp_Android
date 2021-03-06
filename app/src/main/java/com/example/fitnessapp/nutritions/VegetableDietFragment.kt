package com.example.fitnessapp.nutritions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VegetableDietFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VegetableDietFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var itemData: DayData? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (
                it.getSerializable("itemData") != null
            ) {
                itemData = it.getSerializable("itemData") as DayData
            }
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.vegetable_diet_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListDetailDay)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = RecyclerViewDayDetailAdapter(
            listOf(
                itemData,
                itemData,
                itemData,
                itemData
            ) as List<DayData>
        )
        recyclerView.adapter = adapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VegetableTableDiet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VegetableDietFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}