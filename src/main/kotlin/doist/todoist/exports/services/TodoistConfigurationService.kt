package doist.todoist.exports.services

import doist.todoist.exports.entities.TodoistConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TodoistConfigurationService constructor(@Value("\${todoist.token}") val token: String) : ITodoistConfigurationService {
    override fun getConfiguration(): TodoistConfiguration {
        return TodoistConfiguration(todoistToken = token)
    }
}