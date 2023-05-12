package br.com.rf.datasource.commons

import br.com.rf.model.filter.OrderQuery
import br.com.rf.model.filter.Pagination
import br.com.rf.model.filter.PaginationQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

fun PaginationQuery.toPageRequest(): PageRequest {
    val from: Int = this.pageOptions.from.toInt()
    val size: Int = this.pageOptions.size.toInt()
    val pageIndex = from / size
    return PageRequest.of(pageIndex, size, this.toSort())
}

fun OrderQuery.toSort(): Sort {
    return if (this.orderOptions.asc) Sort.by(Sort.Direction.ASC, this.orderOptions.prop) else
        Sort.by(Sort.Direction.DESC, this.orderOptions.prop)
}

fun <T> toPagination(page: Page<T>): Pagination<T> =
    Pagination(
        page.totalElements, page.totalPages,
        page.content
    )

fun <R,T> toPagination(page: Page<R>, conv: (p: R) -> T): Pagination<T> =
    Pagination(
        page.totalElements, page.totalPages,
        page.content.map(conv)
    )
