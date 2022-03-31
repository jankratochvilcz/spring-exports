package doist.todoist.exports.controllers

import doist.todoist.exports.services.GoogleSheetsService
import doist.todoist.exports.services.ITodoistApiService
import org.springframework.stereotype.Component
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Component
class GoogleSheetsExportController constructor(val googleSheetsService: GoogleSheetsService, val todoistApiService: ITodoistApiService) {
    @GetMapping("/sheets")
    suspend fun exports(model: Model): String {
        val items = todoistApiService.getAllItems()
        return items.toString()
    }

}