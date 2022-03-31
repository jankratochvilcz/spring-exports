package doist.todoist.exports.services

import doist.todoist.exports.entities.TodoistConfiguration

interface ITodoistConfigurationService {
    fun getConfiguration(): TodoistConfiguration
}