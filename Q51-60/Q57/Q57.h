/*
 *  Project Euler Problem 57
 *  Yurun SONG
 *  2019-09-29
 *
 *  Problem 57:
 *  It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 *
 *  In the first one-thousand expansions, how many fractions contain a numerator with more digits than the denominator?
 *
 */

#ifndef Q51_60_Q57_H
#define Q51_60_Q57_H

#include <iostream>
#include <vector>

using namespace std;

class Q57 {

public:

    vector<pair<string,string>> expansions;

    Q57(){
        cout<<"In the first one-thousand expansions, how many fractions contain a numerator with more digits than the denominator?\n"<<endl;
    }

    void solver(){
        subExpansion("1","2",1000);
        int count = 0;

        for(pair<string,string> fraction:expansions){
            string num = fraction.first;
            string denom = fraction.second;
            if(num.length()>denom.length()) count++;
        }
        cout<< count <<endl;

    }

    pair<string,string> subExpansion(string num, string denom, int k){
        pair<string,string> output;
        output.first = add(num,denom);
        output.second = denom;
        expansions.push_back(output);

        if(k == 1) {
            return make_pair(num, denom);
        }else{
            return subExpansion(denom,add(multiByTwo(denom),num),k-1);
        }

    }



    string add (string a, string b) {
        string output;
        bool shiftBits = false;

        if (b.length() > a.length()) {
            string temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i <= a.length(); ++i) {

            int a_digits = 0;
            if (a.length() - i > 0) a_digits = a[a.length() - 1 - i] - '0';

            int b_digits = 0;
            int len = b.length();
            if (len - i > 0) b_digits = b[b.length() - 1 - i] - '0';

            int digits = a_digits + b_digits + shiftBits;

            if (i == a.length() && digits == 0) break;

            shiftBits = digits >= 10;

            char reminder = (char) (digits % 10) + '0';

            output.insert(output.begin(), (reminder));

        }

        return output;

    }


    string multiByTwo (string a){
        int shiftBits = 0;
        string output;

        for (int i = a.length()-1; i >= 0; --i){
            int temp = a[i]-'0';
            int digits = temp*2 + shiftBits;

            shiftBits = (digits >= 10)? digits/10: 0;

            char reminder = (char) (digits % 10) + '0';

            output.insert(output.begin(), (reminder));
        }

        if(shiftBits > 0)
            output.insert(output.begin(), (char)(shiftBits+'0'));

        return output;
    }


};


#endif //Q51_60_Q57_H
