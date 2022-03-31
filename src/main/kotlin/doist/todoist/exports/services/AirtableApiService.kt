package doist.todoist.exports.services

import doist.todoist.exports.entities.Item
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodilessEntity
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.util.UriBuilder

data class AirTableListResponse (val records: Array<AirTableListRecord>)

data class AirTableListRecord (val id: String)

data class AirTableRow (val id: String, val content: String)

data class AirTableRowInsertRequest(val fields: Map<String, String>)

@Component
class AirtableApiService constructor(val configurationService: IAirtableConfigurationService) : IAirtableApiService {
    override suspend fun refreshTable(items: Array<Item>) {
        val client = getClient()

        deleteRecords(client)
        addRecords(items, client)
    }

    private suspend fun addRecords(items: Array<Item>, client: WebClient) {
        for (item in items) {
            client
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(AirTableRowInsertRequest(
                    fields = mapOf(Pair("Content", item.content)))))
                .retrieve()
                .awaitBodilessEntity()
        }

    }

    private suspend fun deleteRecords(client: WebClient) {
        val recordsToDelete = client
            .get()
            .uri { builder: UriBuilder -> builder
                .queryParam("view", "Grid view")
                .queryParam("maxRecords", 1000)
                .build() }
            .retrieve()
            .awaitBody<AirTableListResponse>()

        for (record in recordsToDelete.records) {
            client
                .delete()
                .uri { builder: UriBuilder -> builder
                    .pathSegment(record.id)
                    .build() }
                .retrieve()
                .awaitBodilessEntity()
        }
    }

    private fun getClient(): WebClient {
        val configuration = configurationService.getConfiguration()

        return WebClient.builder().baseUrl("https://api.airtable.com/v0/${configuration.appId}/")
            .defaultHeaders { headers: HttpHeaders -> headers.setBearerAuth(configuration.token)}
            .build()
    }
}