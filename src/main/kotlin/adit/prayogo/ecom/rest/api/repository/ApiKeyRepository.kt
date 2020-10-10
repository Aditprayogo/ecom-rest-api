package adit.prayogo.ecom.rest.api.repository

import adit.prayogo.ecom.rest.api.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}