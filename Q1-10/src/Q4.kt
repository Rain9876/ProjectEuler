/*
 Project Euler Problem4
 Yurun SONG
 2019-02-21

 Problem4:
 A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 Find the largest palindrome made from the product of two 3-digit numbers.
*/

fun main(args: Array<String>) {
    val result = checkPalindromic().solver(999)
    println(result)
}


class checkPalindromic{
    init {
        println("A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n" +
                "Find the largest palindrome made from the product of two 3-digit numbers.")
    }

    fun solver(digit:Int):Int{

        var largestPalind = 0

        for(i in digit downTo 99){

         for(j in digit downTo 99 ) {

             val product = i * j

             if (isParlind(product) && largestPalind < product) {

                 largestPalind = product
                 break
             // if the product of two number is decreasing, then smaller product will produced.
             }else if(product < largestPalind){
                 break
             }

            }
        }
        return largestPalind



    }

    fun isParlind(x:Int):Boolean{
        val temp = x.toString()
        for (i in 0..temp.length/2){
            if (temp[i] != temp[temp.length-i-1]) {
                return false
            }
        }
      return true
    }
}