package br.com.rf.datasource.entity

import br.com.rf.model.Todo
import java.time.LocalDate
import javax.persistence.*

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