/*
    Project Euler Problem 37
    Yurun SONG
    2019-09-09

    Problem 37:

    The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
    Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */


fun main(args: Array<String>) {
    val tp = TruncatablePrimes()
    tp.solver()
}


class TruncatablePrimes{


    init {
        println("Find the sum of the only eleven primes that are both truncatable from left to right and right to left.")
    }

    fun solver(){
        var count = 0
        var sum = 0
        var num = 10
        while(count < 11){
            if (isRightTruncatablePrimes(num) && isLeftTruncatablePrimes(num)){
                    sum += num
                    count++
                }
            num++
        }
        println(sum)
    }



    fun isLeftTruncatablePrimes(n:Int):Boolean{
        val num = n.toString()
        for(i in 0 until num.length){
            if (!isPrimes(num.substring(i).toInt())){

                return false
            }
        }
        return true
    }


    fun isRightTruncatablePrimes(n:Int):Boolean{
        var num = n
        while(num > 0){
            if(!isPrimes(num)){
                return false
            }
            num = num/10 or 0
        }
        return true
    }

    fun isPrimes(n:Int):Boolean{
        if (n == 1) return false

        var i = 2
        while(i <= Math.sqrt(n.toDouble())){
            if(n%i == 0){
                return false
            }
            i++
        }
        return true
    }


}


