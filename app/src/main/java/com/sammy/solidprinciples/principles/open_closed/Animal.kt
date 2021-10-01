package com.sammy.solidprinciples.principles.open_closed

/*
* Software entities (e.g., classes, modules, functions) should be open for an extension, but closed for modification.
* */
//CASE 1: wrong implementation
open class Animal {
    //Something wrong with this implementation is, if we want to add another animal let's say a lion
    //we will have to modify this method by adding another check which goes against Open-Closed Principle
    fun makeSound(animal: Animal): String {
//        when (animal) {
//            is Cat -> {
//                return "Meowwwww"
//            }
//            is Dog -> {
//                return "Wooof"
//            }
//            else -> {
//                throw Exception("Animal not found")
//            }
//        }
        return ""
    }
}

//CASE 2: The best approach would be to override make sound method in this case in cat and Dog classes by extending animal class
open class OpenClosedAnimal {
    open fun makeSound(): String {
        return ""
    }
}