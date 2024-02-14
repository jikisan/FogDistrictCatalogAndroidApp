package com.jikisan.fogdistrictcatalog.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jikisan.fogdistrictcatalog.Model.VapeProductModel
import com.jikisan.fogdistrictcatalog.ViewModel.ProductPageViewModel
import com.jikisan.fogdistrictcatalog.databinding.ActivityProductsBinding

class ProductsPage : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding;

    private val layoutManager = GridLayoutManager(this, 2)

    private lateinit var viewModel: ProductPageViewModel
    private val listAdapter = ProductsAdapter(this, arrayListOf())

    private val productListDataObserver = Observer<List<VapeProductModel>> { list ->
        list?.let {
            binding.recyclerViewProducts.visibility = View.VISIBLE
            listAdapter.updateProductList(it)
        }
    }

    private val loadingListDataObserver = Observer<Boolean> { isLoading ->
        binding.progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
        if(isLoading) {
            binding.tvErrorList.visibility = View.GONE
            binding.recyclerViewProducts.visibility = View.GONE
        }
    }

    private val errorListDataObserver = Observer<Boolean> { isError ->
        binding.tvErrorList.visibility = if(isError) View.VISIBLE else View.GONE
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setViewModel()
        setAdapter(layoutManager)
        clicks(listAdapter, layoutManager)
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[ProductPageViewModel::class.java]
        viewModel.products.observe(this, productListDataObserver)
        viewModel.loadError.observe(this, errorListDataObserver)
        viewModel.loading.observe(this, loadingListDataObserver)
        viewModel.refresh()


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter(layoutManager: GridLayoutManager) {
        binding.recyclerViewProducts.adapter = listAdapter

        binding.recyclerViewProducts.layoutManager = layoutManager
        listAdapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clicks(adapter: ProductsAdapter, layoutManager: GridLayoutManager){
        // Button to switch to 1 column
        binding.ivOneColumn.setOnClickListener {
            layoutManager.spanCount = 1
            adapter.notifyDataSetChanged()
        }

        // Button to switch to 2 columns
        binding.ivTwoColumn.setOnClickListener {
            layoutManager.spanCount = 2
            adapter.notifyDataSetChanged()
        }

        binding.refreshLayout.setOnRefreshListener {
            binding.recyclerViewProducts.visibility = View.GONE
            binding.tvErrorList.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }
    }

}