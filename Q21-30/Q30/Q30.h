//
// Created by Yurun SONG on 23/05/2019.
// Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
// 1634 = 1^4 + 6^4 + 3^4 + 4^4
// 8208 = 8^4 + 2^4 + 0^4 + 8^4
// 9474 = 9^4 + 4^4 + 7^4 + 4^4
// As 1 = 1^4 is not a sum it is not included.
//
// The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits


#ifndef Q21_30_Q30_H
#define Q21_30_Q30_H


#include <cmath>
#include <iostream>

using namespace std;


class Q30 {

public:
    int powOfFifth[10] = {};

    Q30() {
        cout << "Find the sum of all the numbers that can be written as the sum of fifth powers of their digits."
             << endl;
    }

    // 9(10^m + 10^m-1 + ... 10^0) > (9^5) * m
    // when m = 6, the equation does work
    // 9^5 * 6 = 354294

    void solver() {
        POW();

        int sum = 0;
        for (int i = 2; i < 354294; ++i) {
            int temp = 0;
            int number = i;

            while (number > 0) {

                int d = number % 10;

                number = number / 10 | 0;

                temp += powOfFifth[d];
            }

            if (i == temp) {
                sum += i;
            }

        }
        cout << sum << endl;
    }

    void POW() {
        for (int i = 0; i < 10; ++i) {
            powOfFifth[i] = (int) pow(i, 5);
        }
    }
};


#endif //Q21_30_Q30_H
