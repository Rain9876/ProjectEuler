/*
 Project Euler Problem 42
 Yurun SONG
 2019-09-14

 Problem 42:
    The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
    By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
    Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Q42 {

    private ArrayList<Integer> wordsValue;

    Q42(){
        System.out.println("Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?");
        wordsValue = new ArrayList<>();
    }

    public void solver(){
        String path = "./appendix/p042_words.txt";
        wordsToValue(readFile(path));

        int i = 1;
        int sum = 0;
        int count = 0;

        System.out.println(Arrays.asList(wordsValue.toArray()));

        while(i <= wordsValue.size()){
            sum += i;
            ArrayList<Integer> temp = wordsValue;
            while(temp.contains(sum)){
                 temp.remove(temp.indexOf(sum));
                 count ++;
                 }

            i++;
        }
        System.out.println(count);
    }

    public static String[] readFile(String path){

        String[] content = new String[]{};

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            content = br.readLine().replace("\"","").split(",");

        }catch (IOException e){
            e.printStackTrace();
        }

        return content;
    }


    public void wordsToValue(String[] content){
        for(String word:content){
            int value = 0;
            for(int i = 0; i < word.length(); i++){
                value += word.charAt(i)-'A'+1;
            }
            wordsValue.add(value);
        }
    }



    public static void main(String[] args) {
        Q42 result = new Q42();
        result.solver();
    }
}
