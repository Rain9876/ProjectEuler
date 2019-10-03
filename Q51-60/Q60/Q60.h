/*
 *  Project Euler Problem 60
 *  Yurun SONG
 *  2019-10-02
 *
 *  Problem 60:
 *
 *   The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
 *   Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 *
 */

#ifndef Q51_60_Q60_H
#define Q51_60_Q60_H

#include <iostream>
#include <cmath>
#include <vector>
#include <set>

using namespace std;

class Q60 {
public:

    vector<int> PRIMES;

    Q60() {
        cout<<"Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime."<<endl;
    }

    void solver() {

        int result = INT_MAX;

        generatePrimes(30000);

        vector<vector<int>> pairs(PRIMES.size());

        for (int a = 1; a < PRIMES.size(); ++a) {
            if (PRIMES[a] * 5 >= result) break;
            vector<int> temp1;

            if (pairs[a].empty()) {
                temp1.push_back(PRIMES[a]);
                pairs[a] = temp1;
            }

            for(int b = a+1; b < PRIMES.size(); ++b){

                if (PRIMES[a] + PRIMES[b] * 4 >= result) break;
                if(!isPrimeSets(pairs[a],PRIMES[b])) continue;
                pairs[a].push_back(PRIMES[b]);



                for (int c = b+1; c < PRIMES.size(); ++c) {
                    if(c == PRIMES.size()-1) pairs[a].pop_back();

                    if (PRIMES[a] + PRIMES[b] +PRIMES[c] * 3 >= result) {
                        pairs[a].pop_back();
                        break;
                    }
                    if(!isPrimeSets(pairs[a],PRIMES[c])) continue;
                    pairs[a].push_back(PRIMES[c]);



                    for (int d = c+1; d < PRIMES.size(); ++d) {
                        if(d == PRIMES.size()-1) pairs[a].pop_back();

                        if (PRIMES[a] + PRIMES[b] + PRIMES[c] + PRIMES[d] * 2 >= result) {
                            pairs[a].pop_back();
                            break;
                        }

                        if (!isPrimeSets(pairs[a], PRIMES[d])) continue;
                        pairs[a].push_back(PRIMES[d]);


                        for (int e = d+1; e < PRIMES.size(); ++e) {

                            if(e == PRIMES.size()-1) pairs[a].pop_back();

                            if (PRIMES[a] + PRIMES[b] + PRIMES[c] +PRIMES[d]+PRIMES[e] >= result) {
                                pairs[a].pop_back();
                                break;
                            }

                            if (!isPrimeSets(pairs[a], PRIMES[e])) continue;

                            pairs[a].push_back(PRIMES[e]);


                            if (result > PRIMES[a] + PRIMES[b] + PRIMES[c] + PRIMES[d] + PRIMES[e])
                                result = PRIMES[a] + PRIMES[b] + PRIMES[c] + PRIMES[d] + PRIMES[e];

                            cout<< PRIMES[a]<<"+"<< PRIMES[b]<<"+"<< PRIMES[c]<<"+"<< PRIMES[d]<<"+"<< PRIMES[e] << endl;
                            cout<< PRIMES[a]+ PRIMES[b]+ PRIMES[c]+ PRIMES[d]+ PRIMES[e] << endl;

                            break;
                        }
                    }
                }

            }






        }
    }


    void generatePrimes(int n) {
        for (int i = 1; i <= n; ++i) {
            if (is_prime(i)) PRIMES.push_back(i);
        }
    }

    bool isPrimeSets(vector<int> s, int num) {
        for (int ele: s) {
            if (!hasProperty(ele, num)) return false;
        }
        return true;
    }


    bool hasProperty(int a, int b) {

        string num1 = to_string(a);
        string num2 = to_string(b);

        bool property1 = is_prime(stol(num1 + num2));
        bool property2 = is_prime(stol(num2 + num1));

        return property1 && property2;
    }


    bool is_prime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        for (int i = 2; i < sqrt(n) + 1; ++i) {
            if (n % i == 0) return false;
        }
        return true;

    }

};


#endif //Q51_60_Q60_H
