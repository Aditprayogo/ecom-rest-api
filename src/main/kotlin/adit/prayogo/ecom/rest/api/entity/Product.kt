package adit.prayogo.ecom.rest.api.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product (

        @Id
        val id : String,

        @Column(name = "name")
        val name: String,

        @Column(name = "price")
        val price: Long,

        @Column(name = "quantity")
        val quantity : Int,

        @Column(name = "createdAt")
        val createdAt : Date,

        @Column(name = "updatedAt")
        val updatedAt : Date?

)