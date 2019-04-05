
/*

    Project Euler Problem 17
    Yurun SONG
    2019-04-05

    Problem 17

    If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
    If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?



*/
public class Q17 {

    public Q17(){
        System.out.println("If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?\n");
    }


    public int solver(int number){
        int sum = 0;

        for (int k = 1; k <= number; k++){

            int temp = 0;
            int i = k;

            if (i == 1000){
                temp += NumberList((int) Math.floor(i / 1000)) + NumberList(1000);
                i = i % 1000;
            }

            if (i >= 100 && i < 1000) {
                temp += NumberList((int) Math.floor(i / 100)) + NumberList(100);
                if (i % 100 != 0) temp += 3;
                i = i % 100;
            }

            if (i >= 20 && i < 100){
                temp += NumberList((int) Math.floor(i / 10) * 10);
                i = i % 10;
            }

            if (0 < i && i < 20){
                temp += NumberList(i);
            }


        sum += temp;

        }

        return sum;

    }


    public int NumberList(int number){
        switch (number){
            case 1: return 3;
            case 2: return 3;
            case 3: return 5;
            case 4: return 4;
            case 5: return 4;
            case 6: return 3;
            case 7: return 5;
            case 8: return 5;
            case 9: return 4;
            case 10:return 3;
            case 11: return 6;
            case 12: return 6;
            case 13: return 8;
            case 14: return 8;
            case 15: return 7;
            case 16: return 7;
            case 17: return 9;
            case 18: return 8;
            case 19: return 8;
            case 20: return 6;
            case 30: return 6;
            case 40: return 5;
            case 50: return 5;
            case 60: return 5;
            case 70: return 7;
            case 80: return 6;
            case 90: return 6;
            case 100:return 7;
            case 1000: return 8;
            default: return 0;
        }
    }

    public static void main(String[] args){
        System.out.println(new Q17().solver(1000));
    }
}
