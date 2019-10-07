# Project Euler Problem 65
#    Yurun SONG
#    2019-10-07
#
#    Problem 65:
#       All square roots are periodic when written as continued fractions and can be written in the form:
#
#       Exactly four continued fractions, for N≤13, have an odd period.
#
#       How many continued fractions for N≤10000 have an odd period?
#


class Q65():

    def __init__(self):
        print("Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.")


    def solver(self):
        limit = 101
        d = 1
        n = 2

        for i in range(2,limit):
            temp = d
            conv = 1
            if (i % 3 ==0):
                conv = 2 * int(i/3)  # i/3 must turn to integer instead of double
            d = n
            n = conv*d + temp

        sum = 0

        for num in str(n):
            sum = sum + int(num)
        return sum


if __name__ == "__main__":
    convergentsOfE = Q65()
    print(convergentsOfE.solver())