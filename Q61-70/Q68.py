#    Project Euler Problem 68
#    Yurun SONG
#    2019-10-10
#
#    Problem 68:
#      Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
#      Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.
#
#      It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
#
#      By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.
#
#      Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?



class Q68():
    def __init__(self):
        self.comb = []
        self.result = 0
        self.pent = []

        print("Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a \"magic\" 5-gon ring?")

    def solver(self):

        list = [0,9,8,7,6,5,4,3,2,1]

        self.generPerm(list,0)

        for ele in self.comb:
            same, output, pent = self.is_5Ring(ele)

            temp = int(output)

            if(same and self.result < temp and len(str(temp))==16):

                self.result = int(output)
                self.pent = pent

        # print(self.result)
        print(self.pent)



    def generPerm(self,input, k):

        for i in range(k,len(input)):

            input[k],input[i] = input[i],input[k]

            self.generPerm(input, k+1)

            input[i],input[k] = input[k],input[i]

            if k == len(input)-1:
                results = ""
                for ele in input:
                    results+= str(ele)

                self.comb.append(results)


    def is_5Ring(self, input):

        edge1 = [input[0], input[5], input[6]]
        edge2 = [input[1], input[6], input[7]]
        edge3 = [input[2], input[7], input[8]]
        edge4 = [input[3], input[8], input[9]]
        edge5 = [input[4], input[9], input[5]]

        pent = [edge5,edge4,edge3,edge2,edge1]

        for edge in pent:
            for i in range(0, len(edge)):
                if(edge[i] == "0"):
                    edge[i] = "10"


        pent = sorted(pent, key=lambda x:int(x[0]))

        output = ""

        sumOfEdge = []

        for edge in pent:
            temp = 0

            for ele in edge:

                output += ele

                temp += int(ele)

            sumOfEdge.append(temp)


        same = (sumOfEdge[0] == sumOfEdge[1] and sumOfEdge[1] == sumOfEdge[2] and
        sumOfEdge[2] == sumOfEdge[3] and sumOfEdge[3] == sumOfEdge[4])


        return same, output, pent


if __name__ == "__main__":
    magic5GonRing = Q68()
    magic5GonRing.solver()

