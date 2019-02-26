/*
 Project Euler Problem 9
 Yurun SONG
 2019-02-26

 Problem 9:
       A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
       For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
       There exists exactly one Pythagorean triplet for which a + b + c = 1000.
       Find the product abc.
*/




fun main(args: Array<String>) {
    println(PythagoreanTriplet().solver(1000))
}


class PythagoreanTriplet {
    init {
        println("A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2\n" +
                "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n" +
                "Find the product abc.")
    }

    // a = k(x^2 - y^2)
    // b = 2kxy
    // c = k(x^2 + y^2)
    // a + b + c = 2kxx + 2kxy = 2kx(x+y) = 1000

    fun solver(sum:Int):Int{
        for (a in 1..sum) {
            for (b in a+1..sum) {
                val c = sum - a - b
                  if (a*a + b*b == c*c){
                      return a*b*c
                  }
            }
        }
        return 0
    }
}