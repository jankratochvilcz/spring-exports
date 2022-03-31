package doist.todoist.exports.services

import doist.todoist.exports.entities.AirTableConfiguration

interface IAirtableConfigurationService {
    fun getConfiguration(): AirTableConfiguration
}

