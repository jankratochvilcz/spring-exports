package doist.todoist.exports.services

import doist.todoist.exports.entities.AirTableConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AirtableConfigurationService constructor(@Value("\${airtable.token}") val token: String, @Value("\${airtable.app-id}") val appId: String) : IAirtableConfigurationService {
    override fun getConfiguration(): AirTableConfiguration {
        return AirTableConfiguration(token = token, appId = appId)
    }
}