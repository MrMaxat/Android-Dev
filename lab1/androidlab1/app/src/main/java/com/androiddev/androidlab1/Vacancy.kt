package com.androiddev.androidlab1

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vacancy(
    val vacancyId: Int, // Unique identifier for the vacancy
    val title: String, // Title of the job position
    val employerName: String, // Name of the company offering the job
    val offeredSalary: Int, // Salary offered for the position
    val experienceRequired: String, // Required experience for the job
    val location: String, // Location or address of the company
    val postingDate: String, // Date when the job was posted
    val employmentType: String, // Type of work (e.g., full-time, remote)
    val jobDescription: String, // Detailed description of the job position
    @DrawableRes
    val employerLogo: Int, // Resource ID of the company's logo image
    val applicantsCount: Int, // Total number of applicants or responses
    val viewersCount: Int // Current number of people viewing the job
): Parcelable
