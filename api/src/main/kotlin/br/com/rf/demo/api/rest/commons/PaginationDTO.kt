package br.com.rf.demo.api.rest.commons

import br.com.rf.model.filter.OrderOptions
import br.com.rf.model.filter.PageOptions

open class PaginationDTO (
    open val from: Long? = null,
    open val size: Long? = null,
    open val prop: String? = null,
    open val asc: Boolean? = null
)

fun PaginationDTO.toPagination(): PageOptions {
    return if (from != null && size != null ) PageOptions(from!!, size!!) else
        if (from != null) PageOptions(from!!) else
            if (size != null) PageOptions(size = size!!) else
                PageOptions()
}

fun PaginationDTO.toOrder(): OrderOptions? {
    return if (prop != null && asc != null ) OrderOptions(prop!!, asc!!) else
        if (prop != null) OrderOptions(prop!!) else
            null
}