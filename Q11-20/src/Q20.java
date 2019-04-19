import java.math.BigInteger;

/*

    Project Euler Problem 20
    Yurun SONG
    2019-04-12

    Problem 20 -- Factorial digit sum
    n! means n × (n − 1) × ... × 3 × 2 × 1
    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
    Find the sum of the digits in the number 100!
*/


public class Q20 {

    public Q20(){
        System.out.println("Find the sum of the digits in the number 100!");
    }

    public void solver(){

        BigInteger bi = BigInteger.ONE;

        for (int i = 1; i <= 100; i++){
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        BigInteger sum = new BigInteger("0");

        while(bi.compareTo(new BigInteger("0")) == 1) {

            sum = sum.add(bi.mod(BigInteger.valueOf(10)));

            bi = bi.divide(BigInteger.valueOf(10));
        }

        System.out.println(sum);

    }


    public static void main(String[] args){
        new Q20().solver();
    }
}
