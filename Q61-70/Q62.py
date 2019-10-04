# Project Euler Problem 62
#    Yurun SONG
#    2019-10-04
#
#    Problem 62:
#
#       The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
#       Find the smallest cube for which exactly five permutations of its digits are cube

class Q62():

    def __init__(self):
        print("Find the smallest cube for which exactly five permutations of its digits are cube")

    def solver(self):
        n = 345
        cubes = {}
        perms = {}

        while (True):

            n+=1

            smallestPerm = self.makeLargestPerm(n * n * n)

            if(smallestPerm not in cubes):
                cubes[smallestPerm] = 1
                perms[smallestPerm] = n
            else:
                cubes[smallestPerm] += 1


            if (++cubes[smallestPerm] == 5):
                result = perms[smallestPerm]
                break

        return result*result*result


    def makeLargestPerm(self,num):
        k = num
        digits = [0]*10
        retVal = 0

        while(k > 0):
            digits[k%10]+=1
            k= int(k/10)


        for i in range(9,-1,-1):
            for j in range(0, digits[i]):
                retVal = retVal*10+i

        return retVal



if __name__ == "__main__":
    cubicPermutations = Q62()
    print(cubicPermutations.solver())