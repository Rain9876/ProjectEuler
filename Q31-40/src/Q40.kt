/*
    Project Euler Problem 40
    Yurun SONG
    2019-09-12

    Problem 40:

    An irrational decimal fraction is created by concatenating the positive integers:
            0.123456789101112131415161718192021...
    It can be seen that the 12th digit of the fractional part is 1.
    If dn represents the nth digit of the fractional part, find the value of the following expression.
 */

fun main(args: Array<String>) {
    val cc = ChampernownesConstant()
    cc.solver()
}

class ChampernownesConstant {
    init {
        println("If dn represents the nth digit of the fractional part, find the value of the following expression.")
    }

    /*
        1       1
        10      1
        100     5
        1000    3
        10000   7
        100000  2
        1000000 1
     */
    fun solver() {
        var i = 1
        var product: Long = 1
        while (i <= 1000000) {
            product *= nthDigit(i)
            i *= 10
        }

        println(product)

    }


    fun nthDigit(n: Int): Int {
        var irrationalLength = 0
        var dth = 0
        while (irrationalLength < n) {
            dth++
            irrationalLength += dth.toString().length

            if (irrationalLength == n) {
                return dth % 10
            }
        }

        val loc = n + dth.toString().length - irrationalLength - 1
        return dth.toString()[loc] - '0'

    }

}