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
class Module1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_module1, container, false)
        val quizButton: Button = view.findViewById(R.id.quiz_button)
        val info:TextView= view.findViewById(R.id.info)
        info.text="""
                    Overview of Android and Its Ecosystem:
                    - Introduction to Android and its history
                    - Android versions and their features
                    - The Android market and its significance
                    
                    Setting Up the Development Environment:
                    - Installing Android Studio
                    - Configuring the Android SDK
                    - Creating and running your first Android project
                    
                    Android Architecture:
                    - Overview of the Android operating system architecture
                    - Key components: Activities, Services, Broadcast Receivers, Content Providers
                    - Understanding the Android application lifecycle
                    
                    Building a Simple User Interface:
                    - XML-based layouts
                    - Basic UI components: TextView, EditText, Button
                    - Handling user input
                """.trimIndent()
        quizButton.setOnClickListener {
            showQuizDialog()
        }
        return view
    }

    private fun showQuizDialog() {
        val quizDialogFragment = QuizDialogFragment.newInstance("Module1")
        quizDialogFragment.show(childFragmentManager, "QuizDialog")
    }
}