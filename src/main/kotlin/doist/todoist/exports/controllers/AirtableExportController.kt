package doist.todoist.exports.controllers

import doist.todoist.exports.services.IAirtableApiService
import doist.todoist.exports.services.ITodoistApiService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
@Controller
@Component
class AirtableExportController constructor(
    val airtableService: IAirtableApiService,
    val todoistApiService: ITodoistApiService) {

    @GetMapping("/sheets", )
    suspend fun exports(model: Model): String {
        val items = todoistApiService.getAllItems()
        airtableService.refreshTable(items)

        model["items"] = items

        return "sheets"
    }
}