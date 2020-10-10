package adit.prayogo.ecom.rest.api.controller

import adit.prayogo.ecom.rest.api.entity.Product
import adit.prayogo.ecom.rest.api.model.*
import adit.prayogo.ecom.rest.api.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(
        val productService: ProductService
) {

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

    /**
     * get products
     */
    @GetMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"]
    )
    fun getProduct(
            @PathVariable("idProduct") id : String
    ) : WebResponse<ProductResponse> {
        val productResponse = productService.get(id)

        return WebResponse(
                code = 200,
                status = "Ok",
                data = productResponse
        )
    }

    /**
     * Update product endpoints
     */
    @PutMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateProduct(
            @PathVariable("idProduct") id : String,
            @RequestBody updateProductRequest: UpdateProductRequest
    ) : WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)

        return WebResponse(
                code = 200,
                status = "Ok",
                data = productResponse
        )
    }

    /**
     * delete product
     */
    @DeleteMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"]
    )
    fun deleteProduct(
            @PathVariable("idProduct") id : String
    ) : WebResponse<String> {

        productService.delete(id)

        return WebResponse(
                code = 200,
                status = "Ok",
                data = id
        )
    }

    /**
     * List product
     */
    @GetMapping(
            value = ["/api/products"],
            produces = ["application/json"]
    )
    fun listProducts(
            @RequestParam(value = "size", defaultValue = "10") size: Int,
            @RequestParam(value = "page", defaultValue = "0") page: Int
    ) : WebResponse<List<ProductResponse>> {

        val request = ListProductRequest(page = page, size = size)
        val response =  productService.list(request)

        return WebResponse(
                code = 200,
                status = "Ok",
                data = response
        )
    }



}