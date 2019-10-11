#    Project Euler Problem 69
#    Yurun SONG
#    2019-10-11
#
#    Problem 69:
#       Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers
#       less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and
#       relatively prime to nine, φ(9)=6.
#
#       It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
#
#       Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum
#


class Q69():
    def __init__(self):
        print("Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum")

    def solver(self):
        result = 1
        primes = self.ESieve(200)
        i = 0
        while(result*primes[i] < 1000000):
            result *= primes[i]
            i+=1
        return result


    def ESieve(self,end):

        primes = [True for i in range(end+1)]

        p = 2

        while(p*p <= end):

            if(primes[p] == True):

                for i in range(p*p, end+1, p):
                    primes[i] = False
            p+=1


        output = []

        for i in range(1,len(primes)):
            if(primes[i]):
                output.append(i)

        return output[1:]


if __name__ == "__main__":
    totientMaximum = Q69()
    print(totientMaximum.solver())
