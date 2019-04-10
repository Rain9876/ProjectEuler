
/*

    Project Euler Problem 18
    Yurun SONG
    2019-04-10

    Problem 18
    By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.


*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Q18 {


    public Q18(){
        System.out.println("Find the maximum total from top to bottom of the triangle below");
    }


    // Accumulate line from the last but one
    public int solver(){

        LinkedList<int[]> triangle =  readFile("./appendix/Q18.txt");

        for (int i = triangle.size()-2; i >= 0; i--){
            int[] lineArr = triangle.get(i);
            for (int j = 0; j < lineArr.length; j++){
                int [] nextLineArr = triangle.get(i+1);
                lineArr[j] = lineArr[j] + Math.max(nextLineArr[j],nextLineArr[j+1]);
            }
        }

       return triangle.get(0)[0];
    }

    // Read the txt file into triangle
    public LinkedList<int[]> readFile(String path){

        LinkedList<int[]> triangle = new LinkedList<>();

        BufferedReader bf;

        try {
            bf = new BufferedReader(new FileReader(path));

            String line = bf.readLine();

            while(line != null){

                String[] temp = line.split("\\s+");

                int[] lineArray = new int[temp.length];

                for(int i = 0; i < temp.length; i++){

                    lineArray[i] = Integer.parseInt(temp[i]);
                }

                triangle.add(lineArray);

                line = bf.readLine();
            }

            bf.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return triangle;

    }

    public static void main(String[] args){
        System.out.println(new Q18().solver());
    }
}
