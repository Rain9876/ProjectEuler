/*
 Project Euler Problem8
 Yurun SONG
 2019-02-25

 Problem 8:
        The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
        In appendix Q8,
        Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
*/

import java.io.File


fun main(args: Array<String>) {
    println(LargestProduct().solver(13))
}


class LargestProduct{
    init {
     println("The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.\n" +
             "In appendix Q8,\n" +
             "Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?\n")
    }


    fun readFile():String{

        val path = "./appendix/Q8.txt"

        val content = File(path).readLines()

        return content.joinToString(separator = "")
    }


    // Int stores values up to 2147483647.
    // Use Long instead

    fun solver(number:Int):Long{

        val content = readFile()

        var maxProduct:Long = 0

        var d = 0

        while (d < content.length - number) {

            val temp = content.subSequence(d, d + number).map { it.toString().toLong() }

            val product = temp.reduce { mul, it -> mul * it }

            maxProduct = maxOf(maxProduct, product)

            d++
        }

        return maxProduct

    }
}
