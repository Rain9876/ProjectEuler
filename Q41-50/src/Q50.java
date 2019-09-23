
/*
 Project Euler Problem 50
 Yurun SONG
 2019-09-22

 Problem 50:
    The prime 41, can be written as the sum of six consecutive primes:
        41 = 2 + 3 + 5 + 7 + 11 + 13

    This is the longest sum of consecutive primes that adds to a prime below one-hundred.

    The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

    Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

import java.util.ArrayList;

public class Q50 {

    private ArrayList<Integer> primeSum = new ArrayList<>();
    private int limit;


    Q50(int limit){
        System.out.println(" Which prime, below one-million, can be written as the sum of the most consecutive primes?");
        this.limit = limit;
    }


    public void solver(){
        generatePrimes();
        int maxSum = 0;
        int maxLength = 0;
        for (int i = 0; i < primeSum.size()-1; i++){
            for(int j = i+1; j < primeSum.size()-1; j ++){
                int sum = primeSum.get(j)-primeSum.get(i);
                if(sum > limit) break;
                if(isPrime(sum)&& maxSum < sum && maxLength < j-i){
                    maxLength = j-i;
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }

    private void generatePrimes() {
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            if (isPrime(i)) {
                sum += i;
                primeSum.add(sum);
            }
        }

    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q50 result = new Q50(1000000);
        result.solver();

    }
}
