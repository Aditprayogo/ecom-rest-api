package adit.prayogo.ecom.rest.api.controller

import adit.prayogo.ecom.rest.api.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException
import adit.prayogo.ecom.rest.api.util.NotFoundException
import adit.prayogo.ecom.rest.api.util.UnAuthorizedException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(
            constraintViolationException: ConstraintViolationException
    ) : WebResponse<String> {

        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundException(notFoundException: NotFoundException) : WebResponse<String>{
        return return WebResponse(
                code = 404,
                status = "Not Found",
                data = "Data Not Found"
        )

    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun unAutohorized(unAuthorizedException: UnAuthorizedException) : WebResponse<String>{
        return return WebResponse(
                code = 401,
                status = "UNAUTHORIZED",
                data = "Please put your X-API-KEY"
        )

    }

}