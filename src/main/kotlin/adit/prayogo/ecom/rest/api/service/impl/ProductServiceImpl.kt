package adit.prayogo.ecom.rest.api.service.impl

import adit.prayogo.ecom.rest.api.entity.Product
import adit.prayogo.ecom.rest.api.model.CreateProductRequest
import adit.prayogo.ecom.rest.api.model.ProductResponse
import adit.prayogo.ecom.rest.api.repository.ProductRepository
import adit.prayogo.ecom.rest.api.service.ProductService
import adit.prayogo.ecom.rest.api.util.NotFoundException
import adit.prayogo.ecom.rest.api.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
        val productRepository: ProductRepository,
        val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        /**
         * Validation request
         */
        validationUtil.validate(createProductRequest)

        val product = Product(
                id = createProductRequest.id!!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdAt = Date(),
                updatedAt = null
        )

        //save to db
        productRepository.save(product)

        return extractProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)

        if (product != null) {
            return extractProductToProductResponse(product)
        }else {
            throw NotFoundException()
        }
    }

    private fun extractProductToProductResponse(product: Product) : ProductResponse {
        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
        )
    }
}