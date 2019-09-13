/*
 Project Euler Problem 33
 Yurun SONG
 2019-07-30

 Problem 33:
    The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

    We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

    There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

    If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
*/


fun main(args: Array<String>) {
    println(32/10)
    val Q33 = DigitCancellingFractions()
    Q33.solver()
}


class DigitCancellingFractions{

    init {
        println("If the product of these four fractions is given in its lowest common terms, find the value of the denominator.")
    }

    fun solver (){
        for(i in 10..99){   // denomintor
            for (j in 10..99){ // nomintor

            }
        }
    }

    fun isCurious(a:Int, b:Int):Boolean {

        if (a != b) {
            if (a % 10 == b / 10) {


            }

            if (a / 10 == b % 10) {

            }

            if (a % 10 == b % 10) {


            }

            if (a / 10 == b / 10) {


            }

        }

    return false

    }

}




