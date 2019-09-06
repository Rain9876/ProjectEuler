/*
    Project Euler Problem 35
    Yurun SONG
    2019-09-07

    Problem 35:
    The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
    How many circular primes are there below one million?
 */

import kotlin.math.sqrt


fun main(args: Array<String>) {
    val cp = CircularPrimes()
    cp.solver()
}



class CircularPrimes{
   init {
       println("How many circular primes are there below one million?")

   }

    // one million, 1,000,000, which is 6 digit
   fun solver() {

        var sum = 0
        for (i in 2 .. 1000000){
            if (isCircularPrimes(i)){
                println(i)
                sum ++
            }

        }

        println(sum)

    }

    fun isPrimes(n: Int):Boolean{
        var i = 2
        while (i <= sqrt(n.toDouble())){
            if (n % i == 0){
                return false
            }
            i++
        }
        return true
    }

    fun isCircularPrimes(n:Int):Boolean{
        var number = n
        val digits = digits(number)

        if (!isPrimes(number)){
            return false
        }

        for (i in 1 until digits.toInt()){

            number = ((number%10)* Math.pow(10.0, digits-1) + (number / 10 or 0)).toInt()
            if(!isPrimes(number)){
                return false
            }
        }

        return true
    }

    fun digits(n:Int):Double{

        var number = n
        var digits = 0
        while (number > 0){
            number = number / 10 or 0
            digits++
        }
        return  digits.toDouble()
    }
}
