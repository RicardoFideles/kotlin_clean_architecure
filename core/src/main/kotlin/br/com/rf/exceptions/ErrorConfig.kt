package br.com.rf.exceptions

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.request.WebRequest

@Configuration
class ErrorConfig {
    @Bean
    fun errorAttributes() = EnhancedErrorAttributes()
}

class EnhancedErrorAttributes : DefaultErrorAttributes() {
    override fun getErrorAttributes(webRequest: WebRequest?, options: ErrorAttributeOptions): MutableMap<String, Any> {
        val attrs = super.getErrorAttributes(webRequest, options.including(ErrorAttributeOptions.Include.MESSAGE))
        val err = getError(webRequest)
        if (err is SCRPException) {
            attrs["errorType"] = err.errorType
        } else {
            attrs["errorType"] = "generic"
        }
        err.printStackTrace()
        return attrs
    }
}
