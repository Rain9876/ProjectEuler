/*
 Project Euler Problem6
 Yurun SONG
 2019-02-22

 Problem6:
    The sum of the squares of the first ten natural numbers is,
    1^2 + 2^2 + ... + 10^2 = 385

    The square of the sum of the first ten natural numbers is,
    (1 + 2 + ... + 10)^2 = 55^2 = 3025

    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/



fun main(args: Array<String>) {
    println(SumSquareDifference().solver(100))
}


class SumSquareDifference{
    init {
        println("The difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.\n" +
                "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.")
    }

    //  number   | sum      | square
    //     1      1^2        1^3
    //     2      1+2^2      1+2^3
    //     3      1+2^2+3^2  1+2^3+3^3
    //     ..     ..         ..
    //
    // sum square - square sum = (i-1) * i^2

    fun solver(number:Int):Int {

        val j = 1..number
        return j.map { (it - 1) * it * it}.sum()

    }
}


