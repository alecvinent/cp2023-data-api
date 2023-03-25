package com.duany.demo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.duany.demo.models.CompositeIndices
import com.duany.demo.services.IndexRepository

class IndexesModelView: ViewModel() {
    private  val indexRepository = IndexRepository()

    fun getIndexes(): LiveData<CompositeIndices>{
        return indexRepository.getIndexes()
    }
}