/*
 *  Project Euler Problem 60
 *  Yurun SONG
 *  2019-10-02
 *
 *  Problem 60:
 *  Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%? *
 */

#include "Q60.h"

int main(){
    Q60 primesPairsSet;
    primesPairsSet.solver();
//    cout<< primesPairsSet.withProperty(3,19);
    return 0;
}