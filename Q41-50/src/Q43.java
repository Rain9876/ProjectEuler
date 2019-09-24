///*
// Project Euler Problem 43
// Yurun SONG
// 2019-09-15
//
// Problem 43:
//    The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
//    Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//        d2d3d4=406 is divisible by 2
//        d3d4d5=063 is divisible by 3
//        d4d5d6=635 is divisible by 5
//        d5d6d7=357 is divisible by 7
//        d6d7d8=572 is divisible by 11
//        d7d8d9=728 is divisible by 13
//        d8d9d10=289 is divisible by 17
//    Find the sum of all 0 to 9 pandigital numbers with this property.
//*/
//
//import java.util.ArrayList;
//
//public class Q43 {
//
//    Q43() {
//        System.out.println("Find the sum of all 0 to 9 pandigital numbers with this property.");
//    }
//
//
//
//    // d2d3d4 % 2 => d4 is even
//    // d3d4d5 % 3 => d3+d4+d5%3
//    // d4d5d6 % 5 => d6 = 0/5
//    // d6d7d8 % 11 => d6 = 5
//
//    public long solver(){
//        ArrayList<String> temp = new ArrayList<>();
//        for(int i = 0 ; i < 10; i++){
//            for(int j = 0; j < 10; j++){
//                for(int k = 0; k < 10; k++){
//                    if(i != j && j != k && i != k){
//                        String output = Integer.toString(i*100 + j *10 + k);
//                        temp.add(output);
//                    }
//                }
//            }
//        }
//
//        for (String ele: temp) {
//            if(Integer.parseInt(ele) % 17 != 0){
//                temp.remove(ele);
//            }
//        }
//
//        for(String ele:temp){
//            allDigits(ele)
//        }
//
//        return 0;
//    }
//
//
//    public ArrayList<String> allDigits(String s){
//        ArrayList<String> output = new ArrayList<>();
//        if(s.length() %3 != 0) s = "0"+s;
//        for (int i = 0; i<10; i++){
//            if (!s.contains(i+"")){
//                output.add(i+s);
//            }
//        }
//        return output;
//    }
//
//    static void permute(int[] a, int k) {
//        if (k == a.length) {
//            String output = "";
//            for (int i = 0; i < a.length; i++) {
//                output += a[i];
//            }
//            System.out.println(output);
//        } else {
//            for (int i = k; i < a.length; i++) {
//                int temp = a[k];
//                a[k] = a[i];
//                a[i] = temp;
//
//                permute(a, k + 1);
//
//                temp = a[k];
//                a[k] = a[i];
//                a[i] = temp;
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        new Q43().solver();
//    }
//}
//
//
