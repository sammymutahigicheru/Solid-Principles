package com.sammy.solidprinciples.principles.liskov_subtitution

/*
* dove-penguine problem
* */

open class Bird{
   protected fun fly(){

   }
    protected fun walk(){

    }
}

class Dove:Bird(){

}
//In this case, a penguine can fly which isn't really the case, a penguine can't fly thus breaking LSP
class Penguine:Bird(){

}

//To follow LSP
open class LSPBird{
    //all birds can walk
    protected fun walk(){

    }
}
open class FlyingBird{
    //Not all birds can fly
    protected fun fly(){

    }
}
class LSPDove:FlyingBird(){

}
class LSPPenguine:LSPBird(){

}
