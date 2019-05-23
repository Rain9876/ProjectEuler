//
// Created by Yurun SONG on 28/04/2019.
// Problem 25
// 1000-digit Fibonacci number
//
// The 12th term, F12, is the first term to contain three digits.
// What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
//

#ifndef Q21_30_Q25_H
#define Q21_30_Q25_H

#include <iostream>
#include <chrono>
#include <cmath>
using namespace std;

class Q25 {

public:

    Q25(){
        cout << "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?\n";
    }

    // Length func = L(n) = floor(1+ log(n,10))
    // fib(n) = [(1+√5)^n - (1-√5)^n] / [(2^n)*√5]
    // When n is close to infinite, fib(n) is close to (1+√5)^n/√5
    // L(fib(n)) = floor(1+log(((1+√5)^n/√5),10))
    // which is floor(1 + nlog(1+√5,10) - 0.5log(5,10)) > 1000

    void solver(int n){
        auto start = chrono::steady_clock::now();

        double value = 0;
        double goldRatio = (1+ sqrt(5))/2;
        int i = 1;

        while (value < 1000){
            i++;
            value = floor(1 + i * log10(goldRatio) - 0.5 * log10(5));
        }

        cout << ceil(4.78497 * n - 3.1127)<< endl;


//        for (int i = 0; i < 10 ;++i) {
//            cout << binetFib(i)<< endl;
//        }

        // for performance measurement
        auto end = chrono::steady_clock::now();

        chrono::microseconds elapse = chrono::duration_cast< chrono::milliseconds > (end-start);

        double nanos = end.time_since_epoch().count() - start.time_since_epoch().count();

        double micros = elapse.count();

        cout << micros/1e6 << endl;
        cout << nanos/1e9 << endl;


    }

    // even and odd fibonacci number
    long fib(int n) {

        if (n <= 2) return 1;
        if (n % 2 == 1) {
            int k = (n + 1) / 2;
            return fib(k) * fib(k) + fib(k - 1) * fib(k - 1);
        } else {
            int k = n / 2;
            return (fib(k - 1) * 2 + fib(k)) * fib(k);
        }

    }


    // binet's Fibonacci formula
    double binetFib(int n){

        double goldRatio = (1 + sqrt(5))/2;

        double f = (pow(goldRatio,n) - pow (-goldRatio,-n)) / sqrt(5);

        return f;
    }




};


#endif //Q21_30_Q25_H
