/*
 *  Project Euler Problem 52
 *  Yurun SONG
 *  2019-09-24
 *
 *  Problem 52:
 *
 *  It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
 *  Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 */

#ifndef Q51_60_Q52_H
#define Q51_60_Q52_H

#include <iostream>

using namespace std;

class Q52 {

public:

    Q52() {
        cout << "Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits\n" << endl;
    }


    void solver() {
        int i = 1;
        int count = 0;
        while (true) {
            for (int j = 2; j <= 6; ++j) {
                int temp = i * j;
                if (containSameDigits(i, temp)) {
                    count++;
                } else {
                    count = 0;
                    break;
                }
            }

            if (count == 5) {
                cout << i << endl;
                break;
            }

            i++;
        }


    }


    bool containSameDigits(int oddDigits, int newDigits) {
        string num1 = to_string(oddDigits);
        string num2 = to_string(newDigits);

        if (num1.length() != num2.length()) return false;

        for (int i = 0; i < num1.length(); ++i) {
            string temp = num2;
            for (int j = 0; j < temp.length(); ++j) {
                if (num1[i] == temp[j]) {
                    temp.erase(temp.begin() + j);
                    break;
                }
                if (j == temp.length() - 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < num2.length(); ++i) {
            string temp = num1;
            for (int j = 0; j < temp.length(); ++j) {
                if (num2[i] == temp[j]) {
                    temp.erase(temp.begin() + j);
                    break;
                }
                if (j == temp.length() - 1) {
                    return false;
                }
            }
        }

        return true;
    }
};


#endif //Q51_60_Q52_H
