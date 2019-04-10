/*
 Project Euler Problem1
 Yurun SONG
 2019-02-20

 Problem1:
 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 Find the sum of all the multiples of 3 or 5 below 1000.

*/

fun main(args: Array<String>) {
    val results = Multiples(1000).solver()
    println(results)
}

class Multiples constructor(value: Int) {

    var value: Int = value

    init {
        println("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" +
                "Find the sum of all the multiples of 3 or 5 below 1000.")
    }

    fun solver(): Int {
        var sum = 0

        for (i in 1..(value / 3)) {
            if (3 * i < value) sum += 3 * i
            if (5 * i < value) sum += 5 * i
        }

        return sum
    }
}
