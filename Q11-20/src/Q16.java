
/*

    Project Euler Problem 16
    Yurun SONG
    2019-03-30

    Problem 16

    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    What is the sum of the digits of the number 2^1000?


*/


public class Q16 {

    public Q16(){
        System.out.println("2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n" +
                " What is the sum of the digits of the number 2^1000?");
    }

    //      5  -> 32        -> 5
    //      10 -> 1024      -> 7
    //      15 -> 32768     -> 26
    //      20 -> 1048576   -> 31
    //      25 -> 33554432  -> 29

    public void solver(int number){

        int[] array = new int[350];
        array[0] = 2;
        int sum = 0;
        int carry = 0;
        for (int i = 1; i < number; i++){
            for (int j = 0; j < array.length; j++){
                int temp = array[j] * 2;
                if (temp > 9){
                    array[j] = (temp%10) + carry;
                    carry = 1;
                }else{
                    array[j] = temp + carry;
                    carry = 0;
                }
            }
        }

        for(int ele: array) {
            System.out.print(ele);
            sum += ele;
        }

        System.out.println("\n"+ sum);
    }


    public static void main(String[] args){
        new Q16().solver(1000);
    }
}
