import java.util.*

/*
    Project Euler Problem 39
    Yurun SONG
    2019-09-11

    Problem 39:

    If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
    {20,48,52}, {24,45,51}, {30,40,50}
    For which value of p ≤ 1000, is the number of solutions maximised?
 */

fun main(args: Array<String>) {
    val irt = IntegerRightriangles()
    irt.solver()
}

class IntegerRightriangles{

    var solutions = TreeMap<Int,Int>()
    init {
        println("For which value of p ≤ 1000, is the number of solutions maximised?")
    }


    fun solver(){
        numberOfSolutions(1000)
        println(solutions.maxBy { it.value })

    }

    // a^2 = mm - nn
    // b^2 = 2mn
    // c^2 = mm + nn
    // gcd(m,n) = 1, m and n are mutual even and odd
    fun numberOfSolutions(p:Int){
        var a = 1
        while(a < p/3){
           var b = a+1;
            while ( b < p/2){
                val c = Math.sqrt((a*a + b*b).toDouble())
                if((c == c.toInt().toDouble()) && (a + b + c < p)){
                    val sum = a+b+c.toInt()
                    if (solutions[sum] == null) {
                        solutions[sum] = 0
                    }
                    solutions[sum] = solutions[sum]!!+ 1
                }
                b++;
            }
            a++
        }

    }
}
