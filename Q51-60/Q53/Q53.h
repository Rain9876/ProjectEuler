/*
 *  Project Euler Problem 53
 *  Yurun SONG
 *  2019-09-25
 *
 *  Problem 53:
 *
 *  It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 *  Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 *  How many, not necessarily distinct, values of (nr) for 1≤n≤100, are greater than one-million?
 */

#ifndef Q51_60_Q53_H
#define Q51_60_Q53_H

#include <iostream>
using namespace std;

class Q53 {


public:
    Q53(){
        cout<<"How many, not necessarily distinct, values of (nr) for 1≤n≤100, are greater than one-million?\n"<<endl;
    }

    int solver(){
        int count = 0;
        for(int n = 1; n <=100; ++n){
            for(int r = 1; r <=n/2; ++r){
                if(CombinatoricCalcualtion(n,r) > 1000000){
                    count += (n-r-r+1);  // numbers from r to n-r are larger than one million
                    break;
                }
            }
        }
        return count;

    }


    long CombinatoricCalcualtion(int n , int r){
        long result = 1;

        for(int i = n-r+1; i <= n; i++){
            result*=i;
        }

        for(int j = 1; j <= r; j++){
            result/=j;
        }

        return result;
    }

};


#endif //Q51_60_Q53_H
