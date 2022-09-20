package com.example.onboarding.util

sealed class Screen(
    val advantage: String,
    val description: String
){

    object First : Screen(
        advantage = "First",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second : Screen(
        advantage = "Sec",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third : Screen(
        advantage = "Third",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
