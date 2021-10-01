package com.sammy.solidprinciples.principles.singleresponsibility

/*
* Every class should do a single job
* */
//CASE 1: Wrong implementation, this should be seperated to three different classes
class Person {
    fun addPersonToDb(){}
    fun getPersonDetails(){}
    fun calculateWeight(){}
}
//CASE 2: Corrects the above class to follow SRP
class SavePerson{
    fun addPersonToDb(){}
}
class PersonDetails{
    fun getPersonDetails(){}
}
class PersonWeight{
    fun calculatePersonWeight(){}
}