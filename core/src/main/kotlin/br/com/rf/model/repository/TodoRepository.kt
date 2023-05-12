package br.com.rf.model.repository

import br.com.rf.model.Todo
import br.com.rf.model.filter.Pagination
import br.com.rf.model.filter.TodoFilter

interface TodoRepository {
    fun fillAllByFilter(filter : TodoFilter): Pagination<Todo>
}