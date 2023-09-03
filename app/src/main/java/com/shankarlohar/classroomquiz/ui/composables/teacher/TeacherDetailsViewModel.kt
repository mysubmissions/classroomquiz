package com.shankarlohar.classroomquiz.ui.composables.teacher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.shankarlohar.classroomquiz.models.Teacher
import kotlinx.coroutines.launch

class TeacherDetailsViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("teachers")
    val teacherDetails: MutableLiveData<Teacher?> = MutableLiveData()

    fun fetchTeacherDetails() {
        val user = auth.currentUser
        if (user != null) {
            val userId = user.uid
            database.child(userId).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val teacher = dataSnapshot.getValue(Teacher::class.java)
                    teacherDetails.postValue(teacher)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error
                }
            })
        }
    }
}
