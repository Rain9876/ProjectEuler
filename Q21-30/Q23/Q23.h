//
// Created by Yurun SONG on 23/04/2019.
// A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
// the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//
// A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n
// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
//

#ifndef Q21_30_Q23_H
#define Q21_30_Q23_H

#include <iostream>
#include <cmath>
#include <vector>

using namespace std;


class Q23 {

public:

    Q23() {
        cout
                << "Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.\n";

    }

    vector<int> abundants = abundantNumber();


    long solver() const {

        long sum = 0;

        for (int i = 0; i < 28124; ++i) {

            if (!isSumOfTwoAbundants(i)) {
                sum += i;
            }
        }

        return sum;

    };


    bool isSumOfTwoAbundants(int n) const {

        if (n >= 28123) return true;

        for (auto i: abundants) {

            if (i >= n) {
                return false;
            }

            int differenceValue = n - i;

            if (sumProperDivisors(differenceValue) > differenceValue) {
//                cout << n << "; " << abundants[i] << "; " << differenceValue << endl;
                return true;
            }
        }

        return false;
    }


    vector<int> abundantNumber() const {

        vector<int> abundantNumber;

        for (int i = 1; i < 28123; i++) {

            if (sumProperDivisors(i) > i) {

                abundantNumber.push_back(i);
            };

        };

        return abundantNumber;
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


#endif //Q21_30_Q23_H
