package adit.prayogo.ecom.rest.api.controller

import adit.prayogo.ecom.rest.api.model.CreateProductRequest
import adit.prayogo.ecom.rest.api.model.ProductResponse
import adit.prayogo.ecom.rest.api.model.WebResponse
import adit.prayogo.ecom.rest.api.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {

    /**
     * Create product endpoints
     */
    @PostMapping(
            value = ["/api/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createProduct(
            @RequestBody createProductRequest: CreateProductRequest
    ) : WebResponse<ProductResponse> {
        val productResponse = productService.create(createProductRequest)

        return WebResponse(
                code = 200,
                status = "Ok",
                data = productResponse
        )
    }

}