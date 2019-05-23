//
// Created by Yurun SONG on 19/04/2019.
//  Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//  If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
//  For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
//  Evaluate the sum of all the amicable numbers under 10000.
//

#ifndef Q21_30_Q21_H
#define Q21_30_Q21_H

#include <iostream>
#include <cmath>

using namespace std;

class Q21 {

public:

    Q21() {
        cout << "Evaluate the sum of all the amicable numbers under 10000.\n";
    };

    int solver(int bound) const {

        int sumAmicable = 0;
        for (int i = 1; i <= bound; i++) {
            int j = sumProperDivisors(i);
            if (j <= bound && j != i && sumProperDivisors(j) == i) {
                sumAmicable += i;
                sumAmicable += j;
                cout << i << " & " << j << "\n";
            }
        }

        return sumAmicable / 2;       // duplicated pairs


    };

    int sumProperDivisors(int number) const {

        int sum = 0;

        for (int i = 1; i <= sqrt(number); i++) {

            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }

            }

        }

        sum -= number;  // proper divisor

        return sum;
    };

};


#endif //Q21_30_Q21_H
