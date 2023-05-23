package br.com.rf.usecase.todo

import br.com.rf.exceptions.ErrorTypes
import br.com.rf.exceptions.InvalidInputException
import br.com.rf.model.Todo
import br.com.rf.model.filter.Pagination
import br.com.rf.model.filter.TodoFilter
import br.com.rf.model.repository.TodoRepository
import br.com.rf.usecase.UseCase
import org.springframework.stereotype.Service

@Service
class GetTodos(
    private val repository: TodoRepository
): UseCase<TodoFilter, Pagination<Todo>> {
    override fun execute(filter: TodoFilter): Pagination<Todo> {
        if(filter.description.isNullOrBlank()){
            throw InvalidInputException("Field 'description' is null or blank", ErrorTypes.FIELDS.value)
        }
        return repository.fillAllByFilter(filter)
    }
}