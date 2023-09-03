package com.shankarlohar.classroomquiz.ui.composables.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.shankarlohar.classroomquiz.models.Teacher
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().getReference("Teachers")

    fun createTeacherAccount(email: String, password: String, teacher: Teacher, callback: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val teacherId = user?.uid ?: ""

                    // Update the display name
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName("${teacher.firstName} ${teacher.lastName}")
                        .build()

                    user?.updateProfile(profileUpdates)

                    // Save the teacher details in the Realtime Database
                    database.child(teacherId).setValue(teacher.copy(teacherId = teacherId))
                        .addOnSuccessListener {
                            callback(true, null)
                        }
                        .addOnFailureListener { e ->
                            callback(false, e.localizedMessage)
                        }
                } else {
                    callback(false, task.exception?.localizedMessage)
                }
            }
    }

    fun login(email: String, password: String, onLoginSuccess: () -> Unit, onLoginError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onLoginSuccess()
                    } else {
                        onLoginError(task.exception?.message ?: "An error occurred.")
                    }
                }
            } catch (e: Exception) {
                onLoginError(e.message ?: "An error occurred.")
            }
        }
    }

}
