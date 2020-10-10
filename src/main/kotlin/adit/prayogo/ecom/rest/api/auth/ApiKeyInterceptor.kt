package adit.prayogo.ecom.rest.api.auth

import adit.prayogo.ecom.rest.api.repository.ApiKeyRepository
import adit.prayogo.ecom.rest.api.util.UnAuthorizedException
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(
        val apiKeyRepository: ApiKeyRepository
) : WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {

        val apiKey = request.getHeader("X-Api-Key")

        if (apiKey == null) {
            throw UnAuthorizedException()
        }

        if (!apiKeyRepository.existsById(apiKey)) {
            //Not Exist
            throw UnAuthorizedException()
        }

        //exist


    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        //not used
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        //not used
    }
}