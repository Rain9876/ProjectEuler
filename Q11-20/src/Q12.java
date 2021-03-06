/*

    Project Euler Problem 12
    Yurun SONG
    2019-03-07

    Problem 12

    The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be

    1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

    Let us list the factors of the first seven triangle numbers:

    1: 1
    3: 1,3
    6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28

    We can see that 28 is the first triangle number to have over five divisors.

    What is the value of the first triangle number to have over five hundred divisors?

*/



public class Q12 {


    public Q12(){
        System.out.println("What is the value of the first triangle number to have over five hundred divisors?");
    }


    // sum of first n element = (1+n)*(n)/2
    // possible number of factors (500/2)^2
    // n ≥ 500

    public long solver (int value) {

        long sum = 0;

        int i = 1;

        while(factors(sum) < value){

            sum += i;

            i++;

        }

        return sum;

    }




    private int factors(long number){

        int numberOfFactors = 0;

        double limit = Math.sqrt(number);

        for(int i = 1; i <= limit;i++)

            if (number % i == 0) {
                numberOfFactors += 2;
            }

        if (Math.sqrt(number)%1 == 0)
            numberOfFactors --;


        return numberOfFactors;
    }

    // online PrimeFactorisation formula
    private int PrimeFactorisation (long number){

        int numberOfFactors = 1;
        long temp = number;

        if (number == 1) return 1;

        for (int i = 2; i <= Math.sqrt(temp);i++){
            int count = 1;
            while(temp % i == 0){
                temp/=i;
                count++;
            }
            numberOfFactors*=count;
        }

        // if number is prime or the left divisor is prime.
        // double the numberOfFactors
        if (temp == number || temp > 1)
            numberOfFactors *= 2;

        return numberOfFactors;
    }



public static void main (String[] args){
    System.out.println(new Q12().solver(500));
}


}
