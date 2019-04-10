/*
    Project Euler Problem 11
    Yurun SONG
    2019-03-04

    Problem 11
    In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
    What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Q11 {

    public Q11(){

        System.out.println("In the 20×20 grid below, four numbers along a diagonal line have been marked in red.\n" +
                "What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?\n");
    }

    public ArrayList<int[]> readFile(String path){

        ArrayList<int[]> output = new ArrayList<>();

        BufferedReader br;

        try {

        br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            while (line != null) {

                String[] splitedLine = line.split("\\s+");

                int[] newLine = new int[splitedLine.length];

                for (int i = 0; i < splitedLine.length; i++)

                    newLine[i] = Integer.parseInt(splitedLine[i]);

                
                output.add(newLine);

                line = br.readLine();
            }

            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return output;

    }

    public long solver(int number){

        ArrayList<int[]> input = readFile("./appendix/Q11.txt");

        long product = 0;

        for (int i = 0; i < input.size(); i++){

                int[] row = input.get(i);

            for( int j = 0; j < row.length; j++) {

                //right
                if (j < row.length - number) {

                    long productTemp = row[j] * row[j + 1] * row[j + 2] * row[j + 3];

                    product = productTemp > product ? productTemp : product;
                }

                // down
                if (i < input.size() - number) {

                    long productTemp = input.get(i)[j] * input.get(i+1)[j] * input.get(i+2)[j] * input.get(i+3)[j];

                    product = productTemp > product ? productTemp : product;
                }

                // down-right
                if (j < row.length - number && i < input.size() - number){

                    long productTemp = input.get(i)[j] * input.get(i+1)[j+1] * input.get(i+2)[j+2] * input.get(i+3)[j+3];

                    product = productTemp > product ? productTemp : product;
                }

                // up-right
                if (j < row.length - number && i > number){

                    long productTemp = input.get(i)[j] * input.get(i-1)[j+1] * input.get(i-2)[j+2] * input.get(i-3)[j+3];

                    product = productTemp > product ? productTemp : product;
                }


            }


        }

        return product;
    }

    public static void main(String[] args){

       System.out.println(new Q11().solver(4));
    }
}
