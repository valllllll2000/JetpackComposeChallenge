package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class Dog(val name: String, val age: Int, val size: String, val imageUrl: String= "", @DrawableRes val imageRes: Int)
