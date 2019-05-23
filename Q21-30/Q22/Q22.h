//
// Created by Yurun SONG on 21/04/2019.
// Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
// For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
// What is the total of all the name scores in the file?
//

#ifndef Q21_30_Q22_H
#define Q21_30_Q22_H

#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <string>

using namespace std;

class Q22 {

public:

    Q22() {
        cout << "What is the total of all the name scores in the file?" << endl;
    };


    map<string, int> readNames(const string &path) const {

        ifstream nameFile(path);


        if (!nameFile) {
            cout << "file not exist";
        }

        char c;
        int sum = 0;
        string name;
        map<string, int> names;

        while (nameFile) {

            nameFile.get(c);

            if (c != '"' && c != ',') {
                sum += (int) c - 64;
                name += c;

            } else if (c == ',' || nameFile.eof()) {       // the final name does not have ',' character
                names.insert(make_pair(name, sum));
                sum = 0;
                name = "";

            }


        }

        nameFile.close();

        return names;

    };

    void solver() const {

        string path = "../appendix/names.txt";

        map<string, int> nameMap = readNames(path);

        auto it = nameMap.begin();

        long nameScore = 0;
        for (int i = 0; i < nameMap.size(); i++) {

            if (it->first == "COLIN") {
                cout << i + 1 << " -> " << it->second << endl;
            }

            nameScore += (i + 1) * it->second;
            ++it;
        }

        cout << nameScore << endl;


    }


};


#endif //Q21_30_Q22_H
