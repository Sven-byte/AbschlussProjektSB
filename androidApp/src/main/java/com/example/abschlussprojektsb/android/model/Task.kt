package com.example.abschlussprojektsb.android.model

import com.example.abschlussprojektsb.model.TaskDto
import java.io.Serializable

data class Task(
    val taskId: String,
    val title: String,
    var isDone: Boolean = false,
    val startDate: String?,
    val endDate: String?,
    val content: String?,
) : Serializable {

    companion object {
        fun fromDto(dto: TaskDto): Task {
            return Task(
                taskId = dto.task_id,
                title = dto.title,
                isDone = dto.is_done,
                startDate = dto.start,
                endDate = dto.end,
                content = dto.content,

            )
        }

        fun List<TaskDto>.toTaskList(): List<Task> {
            return map { dto -> Task.fromDto(dto) }
        }
    }


}
