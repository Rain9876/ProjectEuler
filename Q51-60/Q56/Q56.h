/*
 *  Project Euler Problem 56
 *  Yurun SONG
 *  2019-09-28
 *
 *  Problem 56:
 *  A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
 *  Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 *
 */

#ifndef Q51_60_Q56_H
#define Q51_60_Q56_H

#include <iostream>
#include <vector>
#include <cmath>
#include <numeric>
using namespace std;

class Q56 {

public:
    Q56(){
        cout<< "Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?" << endl;
    }

    void solver(){
        int result = 0;

         for(int i = 99; i > 1; --i){

             if ((9 * len (99, i)) < result) break;

            for(int j = 99; j >90;--j){

                auto ans = BigIntegerCalculation(j,i);

                int digitsSum = accumulate(ans.begin(),ans.end(),0);

                if(digitsSum > result){
                    result = digitsSum;
                }

            }
        }

        cout<< result<<endl;

    }



    double len(int a,int b){
        return 1 + floor(b * log10(a));

    }

};


#endif //Q51_60_Q56_H
