#    Project Euler Problem 70
#    Yurun SONG
#    2019-10-12
#
#    Problem 70:
#       Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
#       The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
#
#       Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
#
#       Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
#


class Q70():
    def __init__(self):
        print("Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.")

    def solver(self):
        primes = self.ESieve(4000)

        bestn = 1

        bestRatio = 10000000

        for i in range(len(primes)):

            for j in range(i,len(primes)):

                n = primes[i] * primes[j]

                result = (primes[i]-1)*(primes[j]-1)

                if(n >= 10000000): break

                ratio = n/result

                if(self.is_permutation(n,result) and bestRatio > ratio):
                    bestRatio = ratio
                    bestn = n

        print(bestn)


    def is_permutation(self,num1,num2):

        temp1 = str(num1)
        temp2 = str(num2)

        if(len(temp1) != len(temp2)): return False

        for i in str(num1):
            index = temp2.find(i)
            temp2 = temp2[:index]+temp2[index+1:]

        if(len(temp2) != 0): return False

        # for i in str(num2):
        #     index = temp1.find(i)
        #     temp1 = temp1[:index]+temp1[index+1:]
        #
        # if(len(temp1) != 0): return False

        return True


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
    totientPermutation = Q70()
    totientPermutation.solver()