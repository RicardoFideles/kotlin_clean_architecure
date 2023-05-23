package br.com.rf.demo.api.rest

import br.com.rf.demo.api.rest.dto.TodoFilterDTO
import br.com.rf.demo.api.rest.dto.toFilter
import br.com.rf.model.Todo
import br.com.rf.model.filter.Pagination
import br.com.rf.usecase.UseCaseExecutor
import br.com.rf.usecase.todo.GetTodos
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage


@RestController
class TodoControllerImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getTodos: GetTodos
):TodoController {

    override fun list(filter: TodoFilterDTO): CompletionStage<Pagination<Todo>> {

        val logger: Logger = LoggerFactory.getLogger(TodoController::class.java)


        logger.debug("This is a debug message")
        logger.info("This is an info message")
        logger.warn("This is a warn message")
        logger.error("This is an error message")


        return useCaseExecutor(
            useCase = getTodos,
            requestDto = filter,
            requestConverter = {it.toFilter()},
            responseConverter = {it}
        )
    }



}