package br.com.rf.demo.api.rest

import br.com.rf.demo.api.rest.dto.TodoFilterDTO
import br.com.rf.model.Todo
import br.com.rf.model.filter.Pagination
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.concurrent.CompletionStage

@RequestMapping("/api/todo")
interface TodoController {

    @GetMapping
    fun list(filter: TodoFilterDTO): CompletionStage<Pagination<Todo>>

}