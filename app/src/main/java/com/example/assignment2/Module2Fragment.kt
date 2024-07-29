package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Module1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Module2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_module2, container, false)
        val quizButton: Button = view.findViewById(R.id.quiz_button)
        val info:TextView= view.findViewById(R.id.info)
        info.text="""
                    Layouts and Views:
                    - Introduction to View and ViewGroup
                    - Common layouts: LinearLayout, RelativeLayout, ConstraintLayout
                    - Using LayoutInflater to create views programmatically
                    
                    Advanced UI Components:
                    - RecyclerView and Adapters
                    - CardView for creating cards
                    - Toolbar and ActionBar for app navigation
                    
                    Styling and Themes:
                    - Applying styles to views
                    - Creating and using themes
                    - Understanding and using resource qualifiers
                    
                    User Interaction and Navigation:
                    - Handling clicks and other user events
                    - Navigation components: Navigation Drawer, Bottom Navigation
                    - Fragment transactions and back stack management
                """.trimIndent()

        quizButton.setOnClickListener {
            showQuizDialog()
        }
        return view
    }

    private fun showQuizDialog() {
        val quizDialogFragment = QuizDialogFragment.newInstance("Module2")
        quizDialogFragment.show(childFragmentManager, "QuizDialog")
    }
}