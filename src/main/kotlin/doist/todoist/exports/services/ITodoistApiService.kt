package doist.todoist.exports.services

import doist.todoist.exports.entities.Item

interface ITodoistApiService {
    suspend fun getAllItems(): Array<Item>
}