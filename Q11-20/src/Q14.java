/*
 Project Euler Problem 14
    Yurun SONG
    2019-03-17

    Problem 14



    The following iterative sequence is defined for the set of positive integers:

    n → n/2 (n is even)
    n → 3n + 1 (n is odd)

    Using the rule above and starting with 13, we generate the following sequence:

    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

    Which starting number, under one million, produces the longest chain?

    NOTE: Once the chain starts the terms are allowed to go above one million.

* */

public class Q14 {

    public Q14(){
        System.out.println(" Which starting number, under one million, produces the longest chain?");

    }

    public long collaz(long temp){

        if (temp <= 1) return 1;

        if (temp % 2 == 0) {

            return 1 + collaz(temp / 2);

        }else {

            return 1 + collaz(3 * temp + 1);
        }
    }


    public long solver(int n){

        long result = 0;
        long index = 0;

        for (int i = 0; i< n; i++){

            long chain = this.collaz(i) - 1;       // not include first one

            if (result <= chain){

                index = i;
                result = chain;
            }

        }

        return index;

    }


    public static void main(String[] args){
        System.out.println(new Q14().solver(1000000));
    }
}
