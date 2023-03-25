package com.duany.campusparty.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.duany.campusparty.R
import com.duany.demo.models.CompositeIndices
import com.duany.demo.services.APIService
import com.duany.demo.services.ServiceBuilder
import com.github.mikephil.charting.charts.LineChart
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GdinfoFragmentChartLine.newInstance] factory method to
 * create an instance of this fragment.
 */
class GdinfoFragmentChartLine : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var lineChart: LineChart? = null
    private var valuesInfo: CompositeIndices? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_gdinfo_chart_line, container, false)

        lineChart = rootView.findViewById<LineChart>(R.id.gdi_lineChart)

        val response = ServiceBuilder.buildService(APIService::class.java)
        response.getIndexes().enqueue(

            object :retrofit2.Callback<CompositeIndices> {
                override fun onResponse(
                    call: retrofit2.Call<CompositeIndices>,
                    response: Response<CompositeIndices>
                ) {
                    valuesInfo = response.body()

                    valuesInfo?.let { drawChart(lineChart, rootView.context, it.gdiIndex) }
                }
                override fun onFailure(call: retrofit2.Call<CompositeIndices>, t: Throwable) {
                    Toast.makeText(rootView.context,"No se pudieron cargar los datos. intente más tarde. Gracias y disculpe las molestias",Toast.LENGTH_LONG).show()
                }
            }
        )
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GdinfoFragmentChartLine.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GdinfoFragmentChartLine().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}