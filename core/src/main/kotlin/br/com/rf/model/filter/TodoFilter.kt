package br.com.rf.model.filter

import java.time.LocalDate

data class TodoFilter (
    val id: Long? = null,
    val description: String? = null,
    val created: LocalDate? = null,
    override val pageOptions: PageOptions = PageOptions(),
    override val orderOptions: OrderOptions =  OrderOptions("created")
) : PaginationQuery(pageOptions, orderOptions)