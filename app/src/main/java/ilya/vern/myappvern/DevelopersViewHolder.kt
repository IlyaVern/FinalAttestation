package ilya.vern.myappvern

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DevelopersViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    private val developersNameTextView: TextView =
        itemView.findViewById(R.id.developers_name_text_view)

    fun bind(name: String){
        developersNameTextView.text = name

    }

}