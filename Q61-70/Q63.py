# Project Euler Problem 63
#    Yurun SONG
#    2019-10-05
#
#    Problem 63:
#
#      The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.
#      How many n-digit positive integers exist which are also an nth power?


class Q64():
    def __init__(self):
        print("How many n-digit positive integers exist which are also an nth power?")


    def solver(self):
        count = 0
        n = 1
        while(True):

            for i in range(1,10):
                if(len(str(i**n)) == n):
                    count+=1

            if(len(str(9**n)) < n):
                break

            n+=1

        return count



if __name__ == "__main__":
    powerfulDigitCounts = Q64()
    print(powerfulDigitCounts.solver())
