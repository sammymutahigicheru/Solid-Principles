package com.sammy.solidprinciples.principles.interface_segregation

interface IVehicle{
   fun openDoors()
   fun drive()
   fun refuel()
   fun stop()
}
//Breaks Interface Segregation Principle
class Bike:IVehicle {
    //Bikes don't have doors
    override fun openDoors() {
        TODO("Not yet implemented")
    }

    override fun drive() {
        TODO("Not yet implemented")
    }
    override fun refuel() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}
//fix
interface Vehicle{
    fun openDoors()
    fun drive()
    fun refuel()
    fun stop()
}
interface IBike{
    fun drive()
    fun refuel()
    fun stop()
}

class BikeImplementation:IBike{
    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun refuel() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}