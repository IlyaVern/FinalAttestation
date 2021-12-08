package ilya.vern.myappvern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DevelopersFragment : Fragment() {

    lateinit var developersRecyclerView: RecyclerView
    lateinit var developersTextView: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_developers, container, false)
        developersTextView = view.findViewById(R.id.developers_text_view)

        val developersNames:List<String> = listOf("Ilya Vern")

        developersRecyclerView = view.findViewById(R.id.developers_recycler_view)
        developersRecyclerView.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter = DevelopersAdapter(developersNames)


        return view
    }



}