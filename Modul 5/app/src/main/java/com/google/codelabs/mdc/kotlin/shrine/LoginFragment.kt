package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)
        val btn = view.findViewById<Button>(R.id.next_button)
        val password = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val password_result = view.findViewById<TextInputLayout>(R.id.password_text_input)
        btn.setOnClickListener {
            if (!isPasswordValid(password.text)) {
                password_result.error = getString(R.string.shr_error_password)
            } else {
                password_result.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        password.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password.text)) {
                password_result.error = null
            }
            false
        }
        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}
