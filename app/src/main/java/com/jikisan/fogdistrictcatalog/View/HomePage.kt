package com.jikisan.fogdistrictcatalog.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.jikisan.fogdistrictcatalog.Model.CategoriesModel
import com.jikisan.fogdistrictcatalog.databinding.ActivityHomepageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding : ActivityHomepageBinding
    private lateinit var adapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clicks()

    }

    private fun clicks() {

        binding.cardDevices.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }
        binding.cardTank.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }
        binding.cardJuice.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }
        binding.cardAcce.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }
        binding.cardMaintenance.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }
        binding.cardMerchandise.setOnClickListener{
            startActivity(Intent(this, ProductsPage::class.java))
        }

    }


}