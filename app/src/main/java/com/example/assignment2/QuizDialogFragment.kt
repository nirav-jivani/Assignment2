package com.example.assignment2

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_MODULE = "module"
class QuizDialogFragment : DialogFragment() {

    private var score = 0
    private var moduleType: String? = null

    companion object {
        private const val ARG_MODULE_TYPE = "module_type"

        @JvmStatic
        fun newInstance(moduleType: String) =
            QuizDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MODULE_TYPE, moduleType)
                }
            }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_quiz_dialog, null)

        val question1 = view.findViewById<RadioGroup>(R.id.question1)
        val question2 = view.findViewById<RadioGroup>(R.id.question2)

        // Get module type from arguments
        moduleType = arguments?.getString(ARG_MODULE_TYPE)

        when (moduleType) {
            "Module1" -> setupModule1Quiz(view)
            "Module2" -> setupModule2Quiz(view)
        }

        builder.setView(view)
            .setTitle("Quiz")
            .setPositiveButton("Submit") { dialog, _ ->
                checkAnswers(question1, question2)
                displayResult(score)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }

    private fun setupModule1Quiz(view: View) {
        // Initialize Module 1 questions
        view.findViewById<TextView>(R.id.question1_text).text = "1. What is the purpose of an Activity in Android development?"
        view.findViewById<RadioButton>(R.id.answer1_q1).text = "To manage the UI and handle user interaction"
        view.findViewById<RadioButton>(R.id.answer2_q1).text = "To handle background tasks"
        view.findViewById<RadioButton>(R.id.answer3_q1).text = "To store and retrieve data"
        view.findViewById<RadioButton>(R.id.answer4_q1).text = "To broadcast messages"

        view.findViewById<TextView>(R.id.question2_text).text = "2. Which file is used to define the UI layout in an Android application?"
        view.findViewById<RadioButton>(R.id.answer1_q2).text = "MainActivity.java"
        view.findViewById<RadioButton>(R.id.answer2_q2).text = "AndroidManifest.xml"
        view.findViewById<RadioButton>(R.id.answer3_q2).text = "activity_main.xml"
        view.findViewById<RadioButton>(R.id.answer4_q2).text = "strings.xml"
    }

    private fun setupModule2Quiz(view: View) {
        // Initialize Module 2 questions
        view.findViewById<TextView>(R.id.question1_text).text = "1. Which layout is best suited for creating a flexible and responsive UI using constraints?"
        view.findViewById<RadioButton>(R.id.answer1_q1).text = "LinearLayout"
        view.findViewById<RadioButton>(R.id.answer2_q1).text = "RelativeLayout"
        view.findViewById<RadioButton>(R.id.answer3_q1).text = "FrameLayout"
        view.findViewById<RadioButton>(R.id.answer4_q1).text = "ConstraintLayout"

        view.findViewById<TextView>(R.id.question2_text).text = "2. What is the purpose of a RecyclerView in Android development?"
        view.findViewById<RadioButton>(R.id.answer1_q2).text = "To display a static list of items"
        view.findViewById<RadioButton>(R.id.answer2_q2).text = "To handle user input events"
        view.findViewById<RadioButton>(R.id.answer3_q2).text = "To efficiently display a large set of data by recycling views"
        view.findViewById<RadioButton>(R.id.answer4_q2).text = "To manage background tasks"
    }

    private fun checkAnswers(question1: RadioGroup, question2: RadioGroup) {
        when (moduleType) {
            "Module1" -> {
                if (question1.checkedRadioButtonId == R.id.answer1_q1) score++
                if (question2.checkedRadioButtonId == R.id.answer3_q2) score++
            }
            "Module2" -> {
                if (question1.checkedRadioButtonId == R.id.answer4_q1) score++
                if (question2.checkedRadioButtonId == R.id.answer3_q2) score++
            }
        }
    }

    private fun displayResult(score: Int) {
        val parentFragment = parentFragment
        if (parentFragment is Module1Fragment || parentFragment is Module2Fragment) {
            val resultView = parentFragment.view?.findViewById<TextView>(R.id.quiz_result)
            resultView?.visibility = View.VISIBLE
            resultView?.text = "Your score: $score/${if (moduleType == "Module1") 2 else 2}"
        }
    }
}
