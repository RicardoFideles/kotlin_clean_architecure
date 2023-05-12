package br.com.rf.demo.api.rest.dto

import br.com.rf.demo.api.rest.commons.PaginationDTO
import br.com.rf.demo.api.rest.commons.toOrder
import br.com.rf.demo.api.rest.commons.toPagination
import br.com.rf.model.filter.TodoFilter
import java.time.LocalDate

class TodoFilterDTO (
    val id: Long? = null,
    val description: String? = null,
    val created: LocalDate? = null,
    override val from: Long? = null,
    override val size: Long? = null,
    override val prop: String? = null,
    override val asc: Boolean? = null
): PaginationDTO()

fun TodoFilterDTO.toFilter(): TodoFilter {
    val ordering = this.toOrder()
    return if (ordering != null) TodoFilter(
        id,
        description,
        created,
        this.toPagination(),
        ordering
    ) else TodoFilter(
        id,
        description,
        created,
        this.toPagination())
}
