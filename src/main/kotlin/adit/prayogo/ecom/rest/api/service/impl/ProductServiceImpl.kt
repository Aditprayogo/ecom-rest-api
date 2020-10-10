package adit.prayogo.ecom.rest.api.service.impl

import adit.prayogo.ecom.rest.api.entity.Product
import adit.prayogo.ecom.rest.api.model.CreateProductRequest
import adit.prayogo.ecom.rest.api.model.ListProductRequest
import adit.prayogo.ecom.rest.api.model.ProductResponse
import adit.prayogo.ecom.rest.api.model.UpdateProductRequest
import adit.prayogo.ecom.rest.api.repository.ProductRepository
import adit.prayogo.ecom.rest.api.service.ProductService
import adit.prayogo.ecom.rest.api.util.NotFoundException
import adit.prayogo.ecom.rest.api.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

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

        return convertProductToProductResponse(product)
    }

    /**
     * Get all product
     */
    override fun get(id: String): ProductResponse {
        val product = findProductByidOrThrowNotFound(id)

        return convertProductToProductResponse(product)
    }

    /**
     * Update product
     */
    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {

        val product = findProductByidOrThrowNotFound(id)

        validationUtil.validate(updateProductRequest)

        product?.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        //save to db
        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    /**
     * delete product
     */
    override fun delete(id: String) {
        val product = findProductByidOrThrowNotFound(id)

        productRepository.delete(product)
    }

    /**
     * List products
     */
    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository
                .findAll(
                        PageRequest.of(listProductRequest.page,
                        listProductRequest.size
                ))

        //convert stream to list
        val product : List<Product> = page.get().collect(Collectors.toList())

        return product.map {
            convertProductToProductResponse(it)
        }
    }

    private fun findProductByidOrThrowNotFound(id : String) : Product {
        val product = productRepository.findByIdOrNull(id)

        if (product == null) {
            throw NotFoundException()
        } else {
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product) : ProductResponse {
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