package doist.todoist.exports.services

import doist.todoist.exports.entities.Item

interface IAirtableApiService {
    suspend fun refreshTable(items: Array<Item>)
}