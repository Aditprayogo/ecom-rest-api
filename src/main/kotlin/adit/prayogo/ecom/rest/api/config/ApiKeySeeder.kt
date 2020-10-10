package adit.prayogo.ecom.rest.api.config

import adit.prayogo.ecom.rest.api.entity.ApiKey
import adit.prayogo.ecom.rest.api.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(
        val apiKeyRepository: ApiKeyRepository
) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {

        if (!apiKeyRepository.existsById(apiKey)) {

            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}