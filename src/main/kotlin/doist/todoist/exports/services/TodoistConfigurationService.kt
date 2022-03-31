package doist.todoist.exports.services

import doist.todoist.exports.entities.TodoistConfiguration
import org.springframework.stereotype.Component

@Component
class TodoistConfigurationService : ITodoistConfigurationService {
    override fun getConfiguration(): TodoistConfiguration {
        return TodoistConfiguration(todoistToken = "4fa251b9adc0f520e227b26b6691092bf6f54062")
    }
}