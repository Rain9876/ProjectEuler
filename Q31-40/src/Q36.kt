/*
    Project Euler Problem 36
    Yurun SONG
    2019-09-08

    Problem 36:
    The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.

    Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

    (Please note that the palindromic number, in either base, may not include leading zeros.)
 */


fun main(args: Array<String>) {
    val dbp = DoubleBasePalindromes()
    dbp.solver()
}

class DoubleBasePalindromes{
    init {
        println("Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.")
    }

    fun solver(){
        var sum:Long = 0;
        for(i in 1 .. 1000000){
            if(isPalindromes(i.toString())){
                val nn = Integer.toBinaryString(i)
                if(isPalindromes(nn)){
                    sum += i.toLong()
                }

            }
        }
        println(sum)
    }

    fun isPalindromes(n:String):Boolean{
        if (n.length % 2 == 0){
            for( i in 0 until n.length/2){
                if (n[i] != n[n.length-i-1]){
                    return false
                }
            }
        }else{
            for( i in 0 until n.length-1/2){
                if (n[i] != n[n.length-i-1]){
                    return false
                }
            }
        }
        return true
    }

    fun Int.toBinaryString():String{
        if (this == 1) {return "1" }else{ return (this/2).toBinaryString() + this % 2}
    }
}