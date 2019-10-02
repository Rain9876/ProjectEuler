/*
 *  Project Euler Problem 59
 *  Yurun SONG
 *  2019-10-01
 *
 *  Problem 59:
 *  Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange). For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 *  A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key. The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 *  For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes. The user would keep the encrypted message and the encryption key in different locations, and without both "halves", it is impossible to decrypt the message.
 *  Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key. If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message. The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 *  Your task has been made easy, as the encryption key consists of three lower case characters. Using p059_cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
 *
 *
 */

#ifndef Q51_60_Q59_H
#define Q51_60_Q59_H

#include <iostream>
#include <vector>
#include <fstream>

using namespace std;


class Q59 {
public:
    Q59() {
        cout << "Your task has been made easy, as the encryption key consists of three lower case characters. "
                "Using p059_cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.\n"
             << endl;
    }


    void solver() {
        string path = "../appendix/p059_cipher.txt";
        int sum;
        vector<int> cipher = readTxt(path);

        bool the = false, and_ = false, to = false;

        for (string key: generateEncryptedKey()) {

            vector<char> decipher;

            for (int i = 0; i < cipher.size(); ++i) {

                int original = cipher[i] ^key[i % 3];

                decipher.push_back((char) original);

                if (i > 3) {
                    the = ((*(decipher.end() - 3) == 't') && (*(decipher.end() - 2) == 'h') &&
                           (*(decipher.end() - 1) == 'e')) || the;
                    and_ = ((*(decipher.end() - 3) == 'a') && (*(decipher.end() - 2) == 'n') &&
                            (*(decipher.end() - 1) == 'd')) || and_;
                    to = ((*(decipher.end() - 2) == 't') && (*(decipher.end() - 1) == 'o')) || to;

                }

                sum += original;


            }

            if (the && and_ && to) {
                cout << sum << endl;
                for (char ele: decipher)
                    cout << ele;
                cout << endl;
            }
            the = false;
            and_ = false;
            to = false;
            sum = 0;

        }

    }

    vector<string> generateEncryptedKey() {
        vector<string> encryptedKey;
        for (int i = 'a'; i <= 'z'; ++i) {
            for (int j = 'a'; j <= 'z'; ++j) {
                for (int k = 'a'; k <= 'z'; ++k) {
                    string temp;
                    temp += (char) i;
                    temp += (char) j;
                    temp += (char) k;

                    encryptedKey.push_back(temp);
                }
            }
        }
        return encryptedKey;
    }


    vector<int> readTxt(string path) {
        ifstream infile;
        infile.open(path.data());


        char c;
        int temp = 0;
        vector<int> cipher;
        while (!infile.eof()) {

            infile >> c;

            if (infile.fail()) {
                cipher.push_back(temp);
            }

            if ((c != ' ') && (c != ',')) {
                temp = temp * 10 + (c - '0');
            }


            if (c == ',') {
                cipher.push_back(temp);
                temp = 0;
            }

        }
        infile.close();

        return cipher;
    }
};


#endif //Q51_60_Q59_H
