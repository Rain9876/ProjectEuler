//
// Created by Yurun SONG on 26/04/2019.
// Problem 23 Lexicographic permutations
//
// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2,
// 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
// The lexicographic permutations of 0, 1 and 2 are:
//
// 012   021   102   120   201   210
//
// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

#ifndef Q21_30_Q24_H
#define Q21_30_Q24_H

#include <iostream>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

class Q24 {

public:

    int factorials[11];                     // Value escapes local scope !!!

    Q24() {
        cout << "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?\n";
    }

    //  1 --> 1
    //  2 --> 1*2
    //  3 --> 1*2*3
    //  ....
    //  9 --> 362880
    // 10 --> 3628800

    string solver(int number) {

        int *factorialValue;

        factorialValue = factorial(10);

        vector<int> permutation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        string list = "";

        int n = 10;

        int remain = 1000000;

        remain--;
        for (int i = 1; i <= 10; ++i) {
            int value = *(factorialValue + n - i);
            auto j = (int) floor(remain / value);
            list += to_string(permutation[j]);
            remain -= value * j;
            permutation.erase(permutation.begin() + j);
        }


        return list;

    }


    int *factorial(int n) {

        factorials[0] = 1;

        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * (i);
        }


        return factorials;
    };

};


#endif //Q21_30_Q24_H
