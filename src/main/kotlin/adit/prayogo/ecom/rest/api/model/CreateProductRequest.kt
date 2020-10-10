package adit.prayogo.ecom.rest.api.model

data class CreateProductRequest (

        val id : String,

        val name : String,

        val price: Long,

        val quantity: Int
)