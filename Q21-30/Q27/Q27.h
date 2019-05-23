//
// Created by Yurun SONG on 22/05/2019.
//
// n^2+an+b, where |a|<1000 and |b|≤1000
// Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
// primes for consecutive values of n, starting with n=0.
//

#ifndef Q21_30_Q27_H
#define Q21_30_Q27_H

#include <iostream>
#include <cmath>

using namespace std;

class Q27 {

public:
    Q27() {
        cout << "Find the product of the coefficients, a and b, for the quadratic expression" << endl;
    }



    // n = 0, b is a prime
    // n = 1, 1 + a + b, then b is odd, 1 is odd, then a should be odd.

    void solver() {
        int nMax = 0;
        int aMax = 0;
        int bMax = 0;

        for (int a = -999; a < 1000; a += 2) {
            for (int b = -1000; b <= 1000; b++) {

                if (!isPrime(b)) {
                    continue;
                }

                int n = 0;
                while (isPrime(abs(n * n + a * n + b))) {
                    n++;
                }

                if (n > nMax) {
                    aMax = a;
                    bMax = b;
                    nMax = n;
                }

            }
        }

        cout << aMax * bMax << endl;

    }

    bool isPrime(int m) {
        for (int i = 2; i <= sqrt(m); i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

};


#endif //Q21_30_Q27_H
