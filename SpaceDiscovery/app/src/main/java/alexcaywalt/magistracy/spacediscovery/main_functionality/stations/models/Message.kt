package alexcaywalt.magistracy.spacediscovery.main_functionality.stations.models

import java.util.*

class Message(
    var text: String,
    var sender: String,
    var dateTime: Calendar
) {
    override fun toString(): String {
        return "Message(text='$text', sender='$sender', dateTime=$dateTime)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (text != other.text) return false
        if (sender != other.sender) return false
        if (!dateTime.equals(other.dateTime)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text.hashCode()
        result = 31 * result + sender.hashCode()
        result = 31 * result + dateTime.hashCode()
        return result
    }
}