//
// Created by Yurun SONG on 01/05/2019.
//
// A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given.
// Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
// Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
//


#ifndef Q21_30_Q26_H
#define Q21_30_Q26_H

#include <iostream>
#include <cmath>

using namespace std;

class Q26 {

public:

    Q26(){
        cout << "Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.\n";
    }

    // decimal number
    // 1. Terminating fraction => 10^k mod n = 0
    // 2. Completely repeating fraction => (10^k -1) mod n = 0
    // 3. Repeat after a non-repeat part fraction => 10^k(10^m -1) mod n = 0, which is combined case 1 and 2
    // For base d = 10 and q = denominator

    void solver(){
        long max = 1; int k = 1; int cycleIndex = 3;
        for(int d = 3;d <= 1000; d++){
           if (lengthOfFraction(d) > max){
               max = lengthOfFraction(d);
               cycleIndex = d;
           }


        };

        cout<< cycleIndex << endl;

    }


    long lengthOfFraction(int d){
        int i = 1; long k = 0;

        d = makeCoPrimeToTen(d);        // Terminating fraction

        if (d == 1){
            return 0;
        }

        do {
            i = i * 10 % d;
            k++;
        } while(i != 1);

        return k;

    }


private:
        int makeCoPrimeToTen(int n){

        while(n%2==0){
            n = n/2;
        }

        while(n%5 ==0){
            n = n/5;
        }

        return n;
    }

};


#endif //Q21_30_Q26_H
