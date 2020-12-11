package com.fifthlsnacdhomework


data class Person(var name: String, var age: Int){

    var mother: Person? = null
    var father: Person? = null
    var adult : Boolean = age >= 18

    private var siblings : MutableList<Person> = mutableListOf()     //list of brothers and sisters
    //add a sibling to the calling object
    private fun addSib(sib : Person){
        sib.father = this.father
        sib.mother = this.mother
        //assign a sibling a link to the same parents
        siblings.add(sib)
    }
    fun getSiblings() : List<Person> = this.siblings

    //
    private fun countRelativesWithMe() : Int{
        var count =  1 + this.getSiblings().size
        this.father?.let{
            count += it.countRelativesWithMe()
        }
        this.mother?.let{
            count += it.countRelativesWithMe()
        }

        return count
    }

    fun countRelatives() : Int = countRelativesWithMe() - 1


    companion object {
        fun getMe(): Person {
            val me = Person("Rodion", 18)
            me.father = Person("Olexandr", 51)
            me.mother = Person("Tania", 50)

            me.addSib(Person("Artem", 28))
            
            me.mother?.let {  it.father = Person("Daniel", 85) } ?: noInfo()
            me.mother?.let {  it.mother = Person("Anna", 85)  } ?: noInfo()

            me.mother?.addSib(Person("Olga", 53)) ?: noInfo()
            me.mother?.addSib(Person("Petia", 55)) ?: noInfo()

            me.father?.addSib(Person("Emily", 54)) ?: noInfo()

            return me
        }

        private fun noInfo() = println("NO ABOUT PARANT INFO!!!")

    }
}