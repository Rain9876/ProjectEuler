
/*

    Project Euler Problem 13
    Yurun SONG
    2019-03-11

    Problem 13

    Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

*/


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q13 {


    public Q13(){
        System.out.println("Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.");
    }


    public ArrayList<String> readFile(String path){
        Scanner sc = null;
        ArrayList<String> output = new ArrayList<>();
        File file = new File(path);

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()){
                output.add(sc.nextLine());
            }

            sc.close();

        }catch (IOException e){

            e.printStackTrace();

        }

        return output;

    }

    // sum: 0 - 900
    // since a digit sum can up have 3 digit
    // then 10 + 3 = 13, at least 13 digit must to be check

    public void solver(){
        ArrayList<String> list = readFile("./appendix/Q13.txt");
        int[] sum = new int[11];
        for (String number:list){
            for(int i = 0; i < 11; i++){
                sum[i] += Integer.parseInt(String.valueOf(number.charAt(i)));
            }
        }

        for(int i = 10; i >= 1; i--){

            double coeff1 = Math.floor(sum[i]/100);
            double coeff2 = Math.floor(sum[i]/10) - coeff1 * 10;

            if(sum[i] >= 10){
                sum[i-1] += coeff2;
                sum[i] -= coeff2*10;

            }

            if(sum[i] >= 100){

                if (i == 1){

                    sum[i - 1] += coeff1 * 10;

                }else {

                    sum[i - 2] += coeff1;
                }

                sum[i] -= coeff1 * 100;
            }

        }

        String sumStrng = String.join("",Arrays.toString(sum));
        System.out.println(sumStrng);

    }

    //[553, 7, 3, 7, 6, 2, 2, 9, 9, 2]
    //[553, 7, 3, 7, 6, 2, 3, 0, 3, 4, 2]
    //5337376230

    public static void main(String[] args) {
        new Q13().solver();
    }


}
