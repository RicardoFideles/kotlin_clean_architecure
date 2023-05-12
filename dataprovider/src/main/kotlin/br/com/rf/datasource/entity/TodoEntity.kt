package br.com.rf.datasource.entity

import br.com.rf.model.Todo
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "TODO")
class TodoEntity (
    @Id
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "description")
    val description: String,

    @Column(name = "created")
    val created: LocalDate,
)

fun TodoEntity.toTodo() =
    Todo(
    id = this.id,
    description = this.description,
    created = this.created
    )

fun Todo.toTodoEntity() =
    TodoEntity(
        id = this.id,
        description = this.description,
        created = this.created
    )