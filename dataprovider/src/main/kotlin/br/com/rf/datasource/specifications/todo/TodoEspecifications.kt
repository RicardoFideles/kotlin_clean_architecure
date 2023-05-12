package br.com.rf.datasource.specifications.todo

import br.com.rf.datasource.entity.TodoEntity
import br.com.rf.model.filter.TodoFilter
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object TodoEspecifications {

    fun withId(id: Long): Specification<TodoEntity> = Specification { root, _, cb ->
        cb.equal(root.get<Int>("id"), id)
    }

    fun withCreated(data: LocalDate): Specification<TodoEntity> = Specification { root, _, cb ->
        cb.equal(root.get<LocalDate>("created"), data)
    }

    fun withDescription(descricao: String): Specification<TodoEntity> = Specification { root, _, cb ->
        cb.equal(root.get<String>("description"), descricao)
    }

    fun withFilter(filter: TodoFilter): Specification<TodoEntity> {
        var spec: Specification<TodoEntity> = Specification.where(null)

        if(filter.id != null) {
            spec = spec.and(withId(filter.id!!))
        }
        if(filter.created != null) {
            spec = spec.and(withCreated(filter.created!!))
        }

        if(filter.description != null) {
            spec = spec.and(withDescription(filter.description!!))
        }


        return spec
    }
}