#    Project Euler Problem 67
#    Yurun SONG
#    2019-10-09
#
#    Problem 67:
#       By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
#
#           3
#          7 4
#         2 4 6
#        8 5 9 3
#
#       That is, 3 + 7 + 4 + 9 = 23.
#
#       Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'),
#       a 15K text file containing a triangle with one-hundred rows.
#
#       NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this
#       problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take
#       over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
#
import math


class Q67():
    def __init__(self):
        print("Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.")

    def solver(self):
        tri  = []

        with open("p067_triangle.txt") as f:
            for line in f:
                temp = []
                for i in line.split():
                    if(i == '\n'): continue
                    temp.append(int(i))
                tri.append(temp)


        for i in range(len(tri)-2,-1, -1):

            for j in range(0,i+1):

                tri[i][j] += max(tri[i+1][j],tri[i+1][j+1])

        print(tri[0][0])


if __name__ == "__main__":
    maximumPathSum = Q67()
    maximumPathSum.solver()

