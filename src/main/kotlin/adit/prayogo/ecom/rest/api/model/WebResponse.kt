package adit.prayogo.ecom.rest.api.model

data class WebResponse <T>(
        val code : Int,

        val status : String,

        val data : T
)