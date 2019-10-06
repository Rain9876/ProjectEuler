# Project Euler Problem 64
#    Yurun SONG
#    2019-10-06
#
#    Problem 64:
#       All square roots are periodic when written as continued fractions and can be written in the form:
#
#       Exactly four continued fractions, for N≤13, have an odd period.
#
#       How many continued fractions for N≤10000 have an odd period?
#

import math


class Q64():
    def __init__(self):
        print("How many continued fractions for N≤10000 have an odd period?")

    def solver(self):
        limit = 10001

        count=0

        for n in range(2,limit):
            a0 = int(math.sqrt(n))

            if(a0**2 == n): continue

            period = 0
            m = 0
            d = 1
            a = a0

            while(True):

                m = d*a - m
                d = (n - m*m)/d
                a = int((a0+m)/d)
                period+=1

                if(a == 2*a0):break

            if (period % 2 == 1): count+=1;

        return count


if __name__ == "__main__":
    oddPeriodSquareRoots = Q64()
    print(oddPeriodSquareRoots.solver())

