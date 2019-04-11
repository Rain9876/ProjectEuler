
/*

    Project Euler Problem 19
    Yurun SONG
    2019-04-11

    Problem 19
    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/


public class Q19 {



    public Q19(){
        System.out.println("How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?");
    }


    // Sun 0; Mon 1; Tue 2; Weds 3; Thur 4; Fri 5; Sat 6;
    public int solver(){

        int sumMon = 0;
        int day = 1;        // 1990-Jan-01 Sun

        int[] dayofWeek = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int year = 1900; year < 2001; year++){

            if (year%4 == 0 && (year%100 != 0 || year%400 == 0)){
               dayofWeek[1] = 29;
            }else{
               dayofWeek[1] = 28;
            }

            for(int ele: dayofWeek){

                day = (day+ele) % 7;

                if (day == 0 && year >= 1901){
                    sumMon ++;
                }

            }


        }

        return sumMon;
    }

    public static void main(String[] args){
        System.out.println(new Q19().solver());
    }
}
