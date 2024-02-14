package com.jikisan.fogdistrictcatalog.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jikisan.fogdistrictcatalog.Model.SampleData
import com.jikisan.fogdistrictcatalog.Model.VapeProductModel

class ProductPageViewModel (application: Application): AndroidViewModel(application) {

    val products by lazy { MutableLiveData<List<VapeProductModel>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    val loading by lazy { MutableLiveData<Boolean>() }

    fun refresh(){
        getProducts()
    }

    private fun getProducts(){
        val productsList = SampleData.getProductData()
        products.value = productsList
        loadError.value = false
        loading.value = false
    }

}