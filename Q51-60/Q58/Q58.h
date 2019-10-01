/*
 *  Project Euler Problem 58
 *  Yurun SONG
 *  2019-09-30
 *
 *  Problem 58:
 *  Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%? *
 */


#ifndef Q51_60_Q58_H
#define Q51_60_Q58_H

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


class Q58 {

public:

    vector<int> diagNums;

    Q58(){
        cout<<" If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will "
                "be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?\n"<<endl;

    }


    void solver(){

        double percent;
        int numOfPrime = 0;
        int i = 1;
        while (true){
            numOfPrime += diagonalsNums(i);
            percent = numOfPrime *100.0 / diagNums.size();
            if(percent <= 10 && i > 1){

                cout<<i<<endl;
                break;
            }
            i+=2;
        }

    }



    int diagonalsNums(int len) {
        int primeCount = 0;
        if (len == 1) {
            diagNums.push_back(1);
        } else {
            int lastOne = *(diagNums.end()-1);
            for(int i = 0; i < 4; ++i){
                lastOne += len-1;
                if(is_prime(lastOne)) primeCount++;
                diagNums.push_back(lastOne);
            }
        }
        return primeCount;
    }

    bool is_prime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        for(int i = 2; i <= sqrt(n);++i){
            if(n % i == 0) return false;
        }
        return true;
    }
};


#endif //Q51_60_Q58_H
