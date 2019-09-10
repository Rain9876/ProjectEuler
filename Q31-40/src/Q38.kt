/*
    Project Euler Problem 38
    Yurun SONG
    2019-09-10

    Problem 38:

    Take the number 192 and multiply it by each of 1, 2, and 3:
        192 × 1 = 192
        192 × 2 = 384
        192 × 3 = 576
    By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
    The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
    What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

 */


fun main(args: Array<String>) {
    val pm = PandigitalMultiples()
    pm.solver()
}

class PandigitalMultiples{
    init{
        println("What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?")
    }

    // 9 digits & n >= 2
    // Therefore, number * 1 should be at most 4 digits
    // 1 digits (1,2,3,4,5) ~ (1,2,3,4,5,6,7,8,9)
    // 2 digits (1,2,3,4) ~ (1,2,3,4,5)
    // 3 digits (1,2,3)
    // 4 digits (1,2) ~ (1,2,3)

    fun solver(){
        var maxNum = 0;
        for (i in 1 .. 9999){
                var products = ""
            for(j in 1 .. 9){
                products += i*j

                if (products.length > 9) break

                if (maxNum < products.toInt() && isConcatenatedProduct(products)){
                     maxNum = products.toInt()
                }
            }
        }
        println(maxNum)
    }

    fun isConcatenatedProduct(num:String):Boolean{

        if(num.length != 9) return false

        for(i in 1..9){
            if(!num.contains(i.toString())){
                return false
            }
        }

        return true

    }
}
