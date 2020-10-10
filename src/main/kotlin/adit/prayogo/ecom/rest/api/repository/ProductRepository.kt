package adit.prayogo.ecom.rest.api.repository

import adit.prayogo.ecom.rest.api.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>{
}