/*
 *  Project Euler Problem 55
 *  Yurun SONG
 *  2019-09-27
 *
 *  Problem 55:
 *      If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 *      Not all numbers produce palindromes so quickly. For example,
 *          349 + 943 = 1292,
 *          1292 + 2921 = 4213
 *          4213 + 3124 = 7337
 *      That is, 349 took three iterations to arrive at a palindrome.
 *      Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
 *      A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
 *      Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a
 *      number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand,
 *      it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing
 *      power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown
 *      to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
 *
 *      Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 *      How many Lychrel numbers are there below ten-thousand?
 *
 */

#ifndef Q51_60_Q55_H
#define Q51_60_Q55_H

#include <iostream>

using namespace std;


class Q55 {

public:
    Q55() {
        cout << "How many Lychrel numbers are there below ten-thousand?\n" << endl;
    }


    void solver() {

        const int start = 10;
        const int limit = 10000;
        int result = 0;

        for (unsigned int i = start; i < limit; i++) {
            if (isLychrel(i)) result++;
        }

        cout << result << endl;
    }


    bool isLychrel(unsigned int num) {
        string inputNumber = to_string(num);
        for (int i = 0; i < 50; ++i) {
            inputNumber = BigNumAddition(inputNumber, reversedNumber(inputNumber));
            if (is_palindrome(inputNumber))return false;
        }
        return true;
    }

    string BigNumAddition(string a, string b) {
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

    string reversedNumber(string num) {
        string output;
        bool endsWithZeros = true;
        for (int i = num.length() - 1; i >= 0; --i) {

            if (num[i] == '0' && endsWithZeros) {
                continue;
            } else {
                endsWithZeros = false;
            }

            output += num[i];
        }

        return output;
    }


    bool is_palindrome(string num) {
        for (int i = 0; i <= num.length() / 2; ++i) {
            unsigned long end = num.length() - 1 - i;
            if (num[i] != num[end]) {
                return false;
            }
        }
        return true;
    }

};


#endif //Q51_60_Q55_H
