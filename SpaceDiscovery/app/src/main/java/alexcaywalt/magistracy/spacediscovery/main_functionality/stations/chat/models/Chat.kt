package alexcaywalt.magistracy.spacediscovery.main_functionality.stations.chat.models

import alexcaywalt.magistracy.spacediscovery.main_functionality.stations.models.Message
import alexcaywalt.magistracy.spacediscovery.main_functionality.stations.models.Station
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList

class Chat(var station: Station, var messages: ArrayList<Message>, var isActive: Boolean) {

    fun getLastMessage(): Message {
        return messages[messages.size - 1]
    }

    fun addMessage(message: String, sender: String): String {
        return if (message.isNotEmpty()) {
            this.messages.add(
                Message(
                    message,
                    sender,
                    Calendar.getInstance()
                )
            )
            "The message has been sent successfully"
        } else {
            "You did not enter a message"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Chat

        if (station != other.station) return false
        if (messages != other.messages) return false
        if (isActive != other.isActive) return false

        return true
    }

    override fun hashCode(): Int {
        var result = station.hashCode()
        result = 31 * result + messages.hashCode()
        result = 31 * result + isActive.hashCode()
        return result
    }

}