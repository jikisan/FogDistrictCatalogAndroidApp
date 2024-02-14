package com.jikisan.fogdistrictcatalog.Model

class SampleData(){

    companion object {

        public fun getProductData(): ArrayList<VapeProductModel> {
            return productsList
        }

    }
}

private var productsList = arrayListOf(
    VapeProductModel(
        "Mighty Vaporizer",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
        VapeCategory.DEVICES,
        349.99,
        20,
        "The Mighty Vaporizer by Storz & Bickel delivers high-quality vapor in a portable package."
    ),
    VapeProductModel(
        "TFV16 Tank",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
        VapeCategory.TANKS,
        29.99,
        15,
        "The TFV16 Tank by SMOKTech features a massive e-liquid capacity and mesh coil options."
    ),
    VapeProductModel(
        "Crown 5 Tank",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
        VapeCategory.TANKS,
        39.99,
        25,
        "The Crown 5 Tank by Uwell features a top-filling design and adjustable airflow."
    ),
    VapeProductModel(
        "Falcon 2 Tank",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
        VapeCategory.TANKS,
        34.99,
        18,
        "The Falcon 2 Tank by HorizonTech utilizes mesh coils for excellent flavor production."
    ),
    VapeProductModel(
        "Zeus Sub-Ohm Tank",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/TearsOfSteel.jpg",
        VapeCategory.TANKS,
        44.99,
        22,
        "The Zeus Sub-Ohm Tank by GeekVape features top airflow and leak-proof design."
    )
)
