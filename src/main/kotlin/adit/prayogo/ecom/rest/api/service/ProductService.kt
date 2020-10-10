package adit.prayogo.ecom.rest.api.service

import adit.prayogo.ecom.rest.api.model.CreateProductRequest
import adit.prayogo.ecom.rest.api.model.ListProductRequest
import adit.prayogo.ecom.rest.api.model.ProductResponse
import adit.prayogo.ecom.rest.api.model.UpdateProductRequest

interface ProductService  {

    fun create(createProductRequest: CreateProductRequest) : ProductResponse

    fun get(id : String) : ProductResponse

    fun update(id : String, updateProductRequest: UpdateProductRequest) : ProductResponse

    fun delete(id : String)

    fun list(listProductRequest: ListProductRequest) : List<ProductResponse>

}