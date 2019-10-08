#    Project Euler Problem 66
#    Yurun SONG
#    2019-10-08
#
#    Problem 66:
#       Consider quadratic Diophantine equations of the form:
#
#           x2 – Dy2 = 1
#
#       For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.
#
#       It can be assumed that there are no solutions in positive integers when D is square.
#
#       By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
#
#           32 – 2×22 = 1
#           22 – 3×12 = 1
#           92 – 5×42 = 1
#           52 – 6×22 = 1
#           82 – 7×32 = 1
#
#       Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
#
#       Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
#

import math


class Q66():

    def __init__(self):
        print("Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.")


    def solver(self):

        xMax = 0; xD = 0

        for D in range(2,1001):

            temp = int(math.sqrt(D))
            if(temp*temp == D): continue

            x = 1
            y = 1
            xless = 0
            yless = 0
            xmore = 0
            ymore = 0

            init = True

            while(x**2 - D*y**2 != 1):

                if(init):
                    formula = x ** 2 - D * y ** 2

                    if(formula < 1):
                        xless = x
                        yless = y
                    elif (formula > 1):
                        xmore = x
                        ymore = y
                    x+=1

                    if(xmore != 0):
                        init = False
                else:
                    x = xmore+xless
                    y = ymore+yless

                    formula = x ** 2 - D * y ** 2

                    if (formula < 1):
                       xless = x
                       yless = y
                    elif (formula > 1):
                       xmore = x
                       ymore = y

            # print(f'when D is {D}, x is {x}, y is {y}')

            if (x > xMax):
                xMax = x
                xD = D

        return xD


if __name__ == "__main__":
    diophantineEquation = Q66()
    print(diophantineEquation.solver())


