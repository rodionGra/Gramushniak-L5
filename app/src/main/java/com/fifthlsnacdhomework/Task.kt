package com.fifthlsnacdhomework

fun main() {

    val me : Person = Person.getMe()

    println("Me = $me")
    println("My brother: ${me.getSiblings()}")
    println("Mom`s mom = " + me.mother?.mother?.name + "\n")
    println("Amount of relatives who I know:  ${me.countRelatives()}")

}