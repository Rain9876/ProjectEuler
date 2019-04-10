/*
 Project Euler Problem5
 Yurun SONG
 2019-02-22

 Problem5:
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

fun main(args: Array<String>) {
    val result = SmallestMultiple().solver(20)
    println(result.toInt())
}

class SmallestMultiple{
    init {
        println("2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n" +
                "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?")
    }

    fun solver(number:Int):Double{
        val prime = mutableMapOf<Int,Int>()
        val nonPrime = mutableListOf<Int>()

        for(i in 2..number)
            if (isPrime(i)) prime.put(i,1) else nonPrime.add(i)


        for(i in nonPrime){
            var temp = i

            for (j in prime) {
                var index = 0

                while (temp % j.key == 0){
                        temp /= j.key
                        index++

                    if(index >j.value){
                        j.setValue(index)
                    }
                }

            }
        }

        var sum = 1.0

        prime.forEach{
            sum *= Math.pow(it.key.toDouble(),it.value.toDouble())
        }

        println(prime)

        return sum

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