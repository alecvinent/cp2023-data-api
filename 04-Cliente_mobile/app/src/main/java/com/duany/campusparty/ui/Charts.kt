package com.duany.campusparty.ui

import android.content.Context
import androidx.core.content.ContextCompat
import com.duany.campusparty.R
import com.duany.demo.models.CountryData
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


private class NumericFormatter() : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return value.toInt().toString()
    }
}

private fun setUpLineChart(lineChart: LineChart?) {
    with(lineChart) {
        lineChart?.animateX(1200, Easing.EaseInSine)
        lineChart?.description?.text = ""
        lineChart?.description?.isEnabled = true
        lineChart?.setVisibleXRangeMaximum(3F)
        lineChart?.moveViewToX(1F)
        lineChart?.xAxis?.setDrawGridLines(true)

        lineChart?.xAxis?.granularity = 2F
        lineChart?.xAxis?.position = XAxis.XAxisPosition.BOTTOM
        lineChart?.xAxis?.valueFormatter =NumericFormatter()
        var extraRightOffset = 30f
        lineChart?.legend?.textSize =15F
        lineChart?.legend?.verticalAlignment = Legend.LegendVerticalAlignment.TOP
    }
}

fun drawChart(lineChart: LineChart?, context: Context, data: Map<String, CountryData>) {

    val items = data["World"]?.data?.map {
        it.year.toString()
    }

    val worldPoints: List<Entry>? = data["World"]?.data?.map{
        Entry(it.year.toFloat(), it.value)
    }
    val worldDataset= LineDataSet(worldPoints,"World")
    worldDataset.lineWidth = 3f
    worldDataset.valueTextSize = 15f
    worldDataset.mode = LineDataSet.Mode.CUBIC_BEZIER
    worldDataset.color = ContextCompat.getColor(context, R.color.red)
    worldDataset.valueTextColor = ContextCompat.getColor(context, R.color.red)
    worldDataset.enableDashedLine(20F, 10F, 0F)

    val latamPoints: List<Entry>? = data["Latam"]?.data?.map{
        Entry(it.year.toFloat(), it.value)
    }

    val latamDataset= LineDataSet(latamPoints,"Latam")

    latamDataset.lineWidth = 3f
    latamDataset.valueTextSize = 15f
    latamDataset.mode = LineDataSet.Mode.CUBIC_BEZIER
    latamDataset.color = ContextCompat.getColor(context, R.color.blue)
    latamDataset.valueTextColor = ContextCompat.getColor(context, R.color.blue)
    latamDataset.enableDashedLine(20F, 10F, 0F)

    val uruguayPoints: List<Entry>? = data["Uruguay"]?.data?.map{
        Entry(it.year.toFloat(), it.value)
    }

    val uruguayDataset= LineDataSet(uruguayPoints,"Uruguay")

    uruguayDataset.lineWidth = 3f
    uruguayDataset.valueTextSize = 15f
    uruguayDataset.mode = LineDataSet.Mode.CUBIC_BEZIER
    uruguayDataset.color = ContextCompat.getColor(context, R.color.teal_700)
    uruguayDataset.valueTextColor = ContextCompat.getColor(context, R.color.teal_700)
    uruguayDataset.enableDashedLine(20F, 10F, 0F)

    setUpLineChart(lineChart)
    val dataSet = ArrayList<ILineDataSet>()
    dataSet.add(worldDataset)
    dataSet.add(latamDataset)
    dataSet.add(uruguayDataset)

    val lineData = LineData(dataSet)
    lineChart?.data = lineData
    lineChart?.invalidate()
}
