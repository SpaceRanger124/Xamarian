package alexcaywalt.magistracy.spacediscovery.main_functionality.stations.chat

import alexcaywalt.magistracy.spacediscovery.R
import alexcaywalt.magistracy.spacediscovery.main_functionality.stations.models.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MessagesAdapter(var messages: ArrayList<Message>): RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {

    class MessagesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val message: TextView = view.findViewById(R.id.message)
        val sender: TextView = view.findViewById(R.id.sender)
        val dateTime: TextView = view.findViewById(R.id.date_time)

    }

    fun updateMessages(newMessages: List<Message>) {
        messages.clear()
        messages.addAll(newMessages)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessagesViewHolder(
            itemView
        )
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        val message = messages[position]
        holder.message.text = message.text
        holder.sender.text = message.sender
        holder.dateTime.text =  SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(message.dateTime.time)
    }

}