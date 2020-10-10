package adit.prayogo.ecom.rest.api.service

import adit.prayogo.ecom.rest.api.model.CreateProductRequest
import adit.prayogo.ecom.rest.api.model.ProductResponse

interface ProductService  {

    fun create(createProductRequest: CreateProductRequest) : ProductResponse

    fun get(id : String) : ProductResponse

}