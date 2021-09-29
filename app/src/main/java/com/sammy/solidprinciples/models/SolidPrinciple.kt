package com.sammy.solidprinciples.models

import androidx.annotation.StringRes

data class SolidPrinciple(
    val name:String,
    val description:String,
    val codeSample:String
)

internal fun generateSolidPrinciples():List<SolidPrinciple> =
    listOf(
        SolidPrinciple(
            "Single Responsibility Principle",
            "Each class should be responsible for a single part or functionality of the system",
            ""
        ),
        SolidPrinciple(
            "Open-Closed Principle",
            "Software components should be open for extension, but not for modification",
            ""
        ),
        SolidPrinciple(
            "Liskov Substitution Principle",
            "Objects of a superclass should be repleceable with objects of it's subclasses without breaking the system",
            ""
        ),
        SolidPrinciple(
            "Interface Segregation Principle",
            "No client should be forced to depend on methods that it does not use",
            ""
        ),
        SolidPrinciple(
            "Dependency Inversion Principle",
            "High-level modules should not depend on low-level modules, both should depend on abstraction",
            ""
        )
    )