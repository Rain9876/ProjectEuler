/*
 Project Euler Problem7
 Yurun SONG
 2019-02-24

 Problem7:
        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        What is the 10 001st prime number？
*/


fun main(args: Array<String>) {
    println(PrimeNumber().solver(10001))

}


class PrimeNumber{
    init {
        println("By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\n" +
                "What is the 10001st prime number ？")
    }

    fun solver(index:Int):Int{
        var i = 1
        var pr = 2

        while(true){

            if (i == index) return pr

            pr++

            if (isPrime(pr)) i++
        }

    }

    fun isPrime(number: Int):Boolean {
        var i = 2
        while (i <= Math.sqrt(number.toDouble())) {
            if (number % i == 0) return false
            i++
        }
        return true
    }
}