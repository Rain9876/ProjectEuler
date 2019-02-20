/*
 Project Euler Problem3
 Yurun SONG
 2019-02-20

 Problem3:
 The prime factors of 13195 are 5, 7, 13 and 29.
 What is the largest prime factor of the number 600851475143 ?

*/


fun main(args: Array<String>) {
    val results = MaxPrimeFactor().solver(600851475143)
    println(results)
}

class MaxPrimeFactor {

    fun solver(number: Long): Int {
        var numbertemp = number
        var maxPrime = 1
        var i = 3

        // remove the even number
        while((numbertemp % 2).toInt() == 0){
            maxPrime = 2
            numbertemp /= 2
        }

        // prime number can only be odd, increment is 2
        while (i <= Math.sqrt(numbertemp.toDouble())) {

            while ((numbertemp % i).toInt() == 0) {
                maxPrime = i
                numbertemp /= i             // continue to divide number i
            }

            i += 1
        }

        // If the number left is larger than 2, which means is a prime number
        if (numbertemp > 2)
            maxPrime = numbertemp.toInt()

        return maxPrime
    }
}