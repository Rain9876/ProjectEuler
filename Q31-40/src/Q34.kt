/*
    Project Euler Problem 34
    Yurun SONG
    2019-09-06

    Problem 34:
    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
    Find the sum of all numbers which are equal to the sum of the factorial of their digits.
    Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */


fun main(args: Array<String>) {
    val df = DigitFactorials()
    df.solve()

}

// 9!= 362880
// 9! * 7 = 2540160 < 9999999
// 9!* 6 + 2! = 2177282
// Any 9!* 6 or 9!*7 start with 2 as the first digit, so the limit tends to 1999999
// 9!* 5 + 8!*2 = 1895040, therefore 1 must contain
// 9!* 5 + 1! + 8! = 1854721
class DigitFactorials(){

    private val FACT = listOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

    init {
        println("Find the sum of all numbers which are equal to the sum of the factorial of their digits.")
    }


    fun solve(){
        var sum = 0
        for (i in 10 .. 1854721){
            if (isFactorialSum(i)){
                sum += i
            }
        }
        println(sum)
    }

    fun isFactorialSum(n:Int):Boolean{
        var sum = 0
        var number = n
        while (number > 0){
            sum += FACT[number%10]
            number = number / 10 or 0

        }
        if(n == sum){
            return true
        }

        return false
    }

    fun factorial(n:Int):Int{
        var product = 1
        for(i in 1 .. n){
           product *= i
        }
        return product
    }
}
