package ilya.vern.myappvern

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class HelloFragment : Fragment() {

    lateinit var helloTextView: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_hello, container, false)

        helloTextView = view.findViewById(R.id.hello_text_view)

        return view
    }

}