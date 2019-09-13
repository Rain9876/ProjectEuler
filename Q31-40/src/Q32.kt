/*
 Project Euler Problem 32
 Yurun SONG
 2019-05-27

 Problem 32:
    We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

    The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

    Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

    HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
*/


fun main(args: Array<String>){
    val Q32 = PandigitalProducts()
    Q32.solver()
}


class PandigitalProducts {
    init {
        println("Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.\n")
    }


    // 97* 86 = 8342, which is less than 9 digits ==> 2 digit * 2 digit is not possible
    // 135 * 246 = 33210, which is more than 9 digits => 3 digit * 3 digit is not possible
    // 1* 9999 = 9999, which is the maximum, for 9 digits
    fun solver(){
        val sumOfProducts = mutableSetOf<Int>()
        for (i in 1..100){
            for (j in 100..9999){
                    val product = i.toString()+ j.toString()+ (i * j).toString()
                    if (isPandigital(product)){
                        sumOfProducts.add(i * j)
                }
            }

        }
        println(sumOfProducts.sum())
    }


    fun isPandigital(products:String):Boolean{

        if(products.length != 9){
            return false
        }

        var temp:List<String> = listOf("1","2","3","4","5","6","7","8","9")

        for (i in products){
            temp = temp.filter { it != i.toString() }
        }

        if(temp.isEmpty()){
            return true
        }

        return false
    }
}