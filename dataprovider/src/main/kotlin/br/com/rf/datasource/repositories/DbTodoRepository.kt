package br.com.rf.datasource.repositories

import br.com.rf.datasource.entity.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DbTodoRepository : JpaRepository<TodoEntity, Long>,
    JpaSpecificationExecutor<TodoEntity> {
}