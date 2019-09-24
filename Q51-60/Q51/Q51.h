/*
 *  Project Euler Problem 51
 *  Yurun SONG
 *  2019-09-23
 *
 *  Problem 51:
 *
 *  By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 *  By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers,
 *  yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 *  Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family
 *
 */

#ifndef Q51_60_Q51_H
#define Q51_60_Q51_H

#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
#include <regex>

using namespace std;



class Q51 {

public:

    Q51(){
        cout<< "Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family" << endl;

    }

    void solver(){
        vector<int> primes = generatePrimes(10000000);

       for(int ele: primes){
            if(find_pattern(ele)){
                return;
            }
        }

    }

    // K can be 1,2,3
    bool find_pattern(int n){

        string num = to_string(n);

        for(int k = 1;k < num.length(); ++k){
            vector<int> index = containRepeatedDigits(num,k);
            if(index.empty()) continue;

            for(unsigned long ele:index){
                // Todo: Find all possibilities for each position

                vector<int> output;
                for(int i = 0; i < 10; ++i){

                    if(ele == 0 && i ==0) continue;

                    // Todo: Generate replacement
                    string replacement;
                    for(int j = 0; j < k; ++j){
                        replacement += to_string(i);
                    }

                    // Todo: Concatenate replacement and original part
                    string temp = num.substr(0,ele)+replacement+num.substr(ele+k,num.length());

                    if(temp.length() == num.length() && is_prime(stoi(temp))){
                        output.push_back(stoi(temp));
                    }
                }

                if(output.size() == 8){
                    for(auto it = output.begin();it != output.end(); it++){
                        cout << *it << endl;
                    }
                    cout<< "-----------------"<< endl;
                    return true;
                }
            }

        }
        return false;
    }


    vector<int> containRepeatedDigits(string n, int k){
        vector<int> index;
        for (int i = 0; i < n.length(); ++i) {
            int times = 0;
            for(int j = i; j < n.length();++j){
                if(n[i] == n[j]){
                    times++;
                }else{
                    break;
                }
                if(times == k){
                    index.push_back(i);
                }

            }
        }

    }

    vector<int> generatePrimes(int limit){
        vector<int> primes;
        int n = 10000;
        while (n < limit){
            if(is_prime(n)){
                primes.push_back(n);
            }
            n++;
        }
        return primes;

    }


    bool is_prime(int n) const {
        if(n <= 1) return false;
        if(n == 2) return true;
        for(int i = 2; i < sqrt(n);i++){
            if(n%i == 0) return false;
        }
        return true;
    }
};


#endif //Q51_60_Q51_H
