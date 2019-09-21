/*
 Project Euler Problem 48
 Yurun SONG
 2019-09-20

 Problem 48:
 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
*/


public class Q48 {
    Q48() {
        System.out.println(" Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.");
    }


    public void solver() {
        long result = 0;
        long modulo = 10000000000L;

        for (long i = 1; i <= 1000; i++) {
            long temp = 1;
            for (long j = 1; j <= i; j++) {
                temp *= i;
                if (temp >= Long.MAX_VALUE / 1000) {
                    temp %= modulo;
                }

            }
            result += temp;
            result %= modulo;
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        new Q48().solver();
    }
}
