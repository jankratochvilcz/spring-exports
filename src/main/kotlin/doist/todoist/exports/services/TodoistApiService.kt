package doist.todoist.exports.services

import doist.todoist.exports.entities.Item
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBodyOrNull


@Component
class TodoistApiService constructor(val configurationService: ITodoistConfigurationService) : ITodoistApiService {
    override suspend fun getAllItems(): Array<Item> {
        val configuration = configurationService.getConfiguration()
        val client = getClient()

        return client
                .get()
                .uri("/tasks")
                .header(HttpHeaders.AUTHORIZATION, "Bearer ${configuration.todoistToken}")
                .retrieve()
                .awaitBodyOrNull() ?: emptyArray<Item>()
    }

    private fun getClient(): WebClient {
        return WebClient.builder().baseUrl("https://api.todoist.com/rest/v1/").exchangeStrategies(
            ExchangeStrategies.builder().codecs {
                it.defaultCodecs().maxInMemorySize(1000000)
            }.build()
        ).build()
    }
}