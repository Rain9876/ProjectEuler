/*
 Project Euler Problem 47
 Yurun SONG
 2019-09-19

 Problem 47:
    The first two consecutive numbers to have two distinct prime factors are:
        14 = 2 × 7
        15 = 3 × 5

    The first three consecutive numbers to have three distinct prime factors are:
        644 = 2² × 7 × 23
        645 = 3 × 5 × 43
        646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Q47 {

    private ArrayList<Integer> PRIMES = new ArrayList<>();

    Q47() {
        System.out.println("Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?");
        generatePrimes();
    }


    public void solver() {
        int count = 0;
        int i = 100;
        while (true) {
            if (hasFourPrimeFactors(i)) {
                // Todo: Count increases. If count is four,then return i-4.
                count++;
                if (count == 4) {
                    System.out.println(i - 3);
                    return;
                }
            } else {
                // Todo: Reset the count, equals to 0
                count = 0;
            }
            i++;
        }
    }


    public void generatePrimes() {
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                PRIMES.add(i);
            }
        }

    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // First three is in the PRIMES and the last one if it is a PRIME or not
    public boolean hasFourPrimeFactors(int n) {
        Set<Integer> distinctFactors = new TreeSet<Integer>() {
        };

        if (isPrime(n)) return false;

        // Todo: Iterate all the Primes by 2 and 3
        int i = 0;
        while (i <= PRIMES.size() - 1) {

            int prime = PRIMES.get(i);

            if (n % prime == 0) {
                // Todo: If n mod i, then n is divisible by i
                n /= prime;
                distinctFactors.add(prime);
                if (distinctFactors.size() == 3) return isPrime(n);

            } else {
                i++;
            }
            
            if (n == 1) return (distinctFactors.size() == 4);
        }
        return false;
    }

    public static void main(String[] args) {
        Q47 result = new Q47();
//        System.out.println(result.hasFourPrimeFactors(134046));
        result.solver();
    }

}
