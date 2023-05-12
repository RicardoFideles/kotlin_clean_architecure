package br.com.rf.model.filter

data class Pagination<T>(
    val total: Long,
    val pages : Int,
    val itens: Collection<T>
)

open class PaginationQuery(
    open val pageOptions: PageOptions = PageOptions(),
    override val orderOptions: OrderOptions
): OrderQuery(orderOptions)

data class PageOptions(
    val from: Long = 0,
    val size: Long = 10
)

open class OrderQuery(
    open val orderOptions: OrderOptions
)

data class OrderOptions(
    val prop: String,
    val asc: Boolean = true
)
