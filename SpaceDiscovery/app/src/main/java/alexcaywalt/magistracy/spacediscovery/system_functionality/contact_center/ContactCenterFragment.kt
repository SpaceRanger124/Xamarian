package alexcaywalt.magistracy.spacediscovery.system_functionality.contact_center

import alexcaywalt.magistracy.spacediscovery.MESSAGE_TYPE
import alexcaywalt.magistracy.spacediscovery.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.app_bar_side_pane.toolbar
import kotlinx.android.synthetic.main.fragment_contact_center.*

class ContactCenterFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_center, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.toolbar!!.title = resources.getString(R.string.contact_center)
        report_a_problem.setOnClickListener {
            val intent = Intent(activity!!, SelectProblemActivity::class.java)
            activity!!.startActivity(intent)
        }
        proposals_and_suggestions.setOnClickListener {
            val intent = Intent(activity!!, MessageActivity::class.java)
            intent.putExtra(MESSAGE_TYPE, 2)
            activity!!.startActivity(intent)
        }
        leave_feedback.setOnClickListener {
            val intent = Intent(activity!!, MessageActivity::class.java)
            intent.putExtra(MESSAGE_TYPE, 3)
            activity!!.startActivity(intent)
        }
    }

}