/*

    Project Euler Problem 15
    Yurun SONG
    2019-03-24

    Problem 15

    Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
    there are exactly 6 routes to the bottom right corner.

    How many such routes are there through a 20×20 grid?

*/

public class Q15 {

    public Q15(){
        System.out.println("How many such routes are there through a 20×20 grid?");
    }

    /*
    *   1x1 grid -> 2
    *   2x2 grid -> 6
    *   3x3 grid -> 20
    */

    public long solver(int grid){
        // 20 x 20 -> 21 points each
        long [] diagonal = PascalTriangle(grid+2);

        long sum = 0;

        for (long number :diagonal){
            sum += number*number;
        }

        return sum;
    }

    public long[] PascalTriangle(int level){

        long[][] trangle = new long [level][level];

        trangle [0][0] = 1;

        for(int i = 0; i < level;i++){

            for(int j = 0; j < i; j++){

                if (j == i-1 || j == 0){
                    trangle[i][j] = 1;

                }else{
                    trangle[i][j] = trangle[i-1][j]+trangle[i-1][j-1];
                }

                System.out.print(trangle[i][j]);
            }
            System.out.print('\n');

        }

        return trangle[level-1];

    }


    public static void main(String[] args){
        System.out.println(new Q15().solver(20));
    }

}
