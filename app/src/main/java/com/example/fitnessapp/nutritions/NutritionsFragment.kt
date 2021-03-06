package com.example.fitnessapp.nutritions

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.model.DayData
import com.example.fitnessapp.utils.FakeData


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var adapter: RecycleViewDayAdapter? = null

/**
 * A simple [Fragment] subclass.
 * Use the [NutritionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NutritionsFragment : Fragment() {

    // TODO: Rename and change types of parameters
//    private var clickedItemPosition: Int? = -1
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (adapter == null) {
            adapter = RecycleViewDayAdapter(FakeData.arrayDayData)
        }
//        clickedItemPosition = savedInstanceState?.getInt("clickedItemPosition")
//        arguments?.let {
//            clickedItemPosition = it.getInt("clickedItemPosition")
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.nutritions_fragment, container, false)
        val recycleViewDay = view.findViewById<RecyclerView>(R.id.rvListDay)
        recycleViewDay.layoutManager = GridLayoutManager(context, 3)

        adapter!!.listener = object : RecycleViewDayAdapter.IItemListener {
            override fun onClickItem(item: DayData, position: Int) {
//                Log.d("TAG", "onClickItem: ")
                adapter!!.clickedItemPosition = position
                val intent = Intent(activity, DayDetailActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("item", item)
                intent.putExtras(bundle)
                startActivity(intent)
            }

//            override fun onLongClickItem(item: DayData) {
//                Log.e("onLongClick", "onLongClick")
//            }
        }

        //th??m divider cho c??c icon
//        val dividerItemDecoration = DividerItemDecoration(
//            recycleViewDay.getContext(),
//            GridLayoutManager.VERTICAL
//        )
//        recycleViewDay.addItemDecoration(dividerItemDecoration)
        recycleViewDay.adapter = adapter
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NutritionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NutritionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }
}