package doist.todoist.exports.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class Item (@JsonProperty("content") val content: String, @JsonProperty("project_id") val projectId: String)