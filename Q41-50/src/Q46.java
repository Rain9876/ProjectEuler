/*
 Project Euler Problem 46
 Yurun SONG
 2019-09-18

 Problem 46:
   It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

        9 = 7 + 2×1^2
        15 = 7 + 2×2^2
        21 = 3 + 2×3^2
        25 = 7 + 2×3^2
        27 = 19 + 2×2^2
        33 = 31 + 2×1^2

   It turns out that the conjecture was false.

   What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

 */

import java.util.ArrayList;

public class Q46 {

    private ArrayList<Long> PRIMES = new ArrayList<>();

    Q46(){
        System.out.println(" What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?");
        PRIMES.add((long) 1);
    }

    /*
        1 = 1+2*0^2
        3 = 3+2*0^2
        5 = 1+2*2^2
        7 = 5+2*1^2
     */

    public void solver(){
      long i = 1;
      while(true){
          long odd = 2*i-1;
          if(!isPrime(odd) && !isOddCompiste(odd)){
              System.out.println(odd);
              return;
          }
          i++;
      }
    }


    public boolean isOddCompiste(long n){

        // Todo: All the prime less than n

            for(long i = PRIMES.get(PRIMES.size()-1); i < n; i++){
                if(isPrime(i)) PRIMES.add(i);
            }
        // Todo: Iterate all temp = (n - prime)/2

            for (int j = PRIMES.size()-1; j >= 0; j--){

                // Todo: If all temp is not a int and not a square value, then not compisite otherwsie yes.

               double d = (double)(n-PRIMES.get(j))/2;

                if (Math.sqrt(d)%1 == 0){
                    return true;
                }
            }
        return false;


    }


    public boolean isPrime(long n){

        for(int i = 2; i< Math.sqrt(n)+1; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Q46().solver();
    }
}
