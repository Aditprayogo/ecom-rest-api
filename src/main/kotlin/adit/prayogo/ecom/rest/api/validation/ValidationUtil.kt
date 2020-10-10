package adit.prayogo.ecom.rest.api.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class ValidationUtil(
        val validator : Validator
) {

    fun validate(obj : Any) {
        val result = validator.validate(obj)
        /**
         * if size == 0 ? valid : not valid
         */
        if (result.size != 0) {
            //Error
             throw ConstraintViolationException(result)
        }
    }

}