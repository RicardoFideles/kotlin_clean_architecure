package br.com.rf.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

abstract class SCRPException(message: String, val errorType: String = "generic", cause: Throwable? = null) : RuntimeException(message, cause) {
    constructor(message: String, cause: Throwable) : this(message, "generic", cause)
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidInputException(message: String, errorType: String = "generic", cause: Throwable? = null) : SCRPException(message, errorType, cause) {
    constructor(message: String, cause: Throwable) : this(message, "generic", cause)
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class InternalErrorException(message: String, errorType: String = "generic", cause: Throwable? = null) : SCRPException(message, errorType, cause) {
    constructor(message: String, cause: Throwable) : this(message, "generic", cause)
}