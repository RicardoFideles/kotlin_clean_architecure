package br.com.rf.datasource.repositories

import br.com.rf.datasource.commons.toPageRequest
import br.com.rf.datasource.commons.toPagination
import br.com.rf.datasource.entity.TodoEntity
import br.com.rf.datasource.entity.toTodo

import br.com.rf.datasource.specifications.todo.TodoEspecifications
import br.com.rf.model.Todo
import br.com.rf.model.filter.Pagination
import br.com.rf.model.filter.TodoFilter
import br.com.rf.model.repository.TodoRepository
import org.springframework.stereotype.Repository

@Repository
class JpaTodoRepository(
    private val dbTodoRepository: DbTodoRepository
): TodoRepository {
    override fun fillAllByFilter(filter: TodoFilter): Pagination<Todo> {
        return toPagination(dbTodoRepository.findAll(
            TodoEspecifications.withFilter(filter),
            filter.toPageRequest()), TodoEntity::toTodo)
    }
}