import java.lang.reflect.Array;
import java.util.*;

/*
 Project Euler Problem 41
 Yurun SONG
 2019-09-13

 Problem 41:
    We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
    What is the largest n-digit pandigital prime that exists?
*/
public class Q41 {

    private Q41() {
        System.out.println("What is the largest n-digit pandigital prime that exists?");
    }

    // If the digit sum is divisible by three, the whole number is divisible by three and as such not a prime number.
    // Therefore, the largest digit sum 1+2+3+4+5+6+7=28, which is not divisible by three

    public void solver() {
        List<Integer> num = Arrays.asList(7, 6, 5, 4, 3, 2, 1);
        permute(num, 0);

    }


    public void permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
//            System.out.println(Arrays.toString(arr.toArray()));
            int results = 0;
            for (int ele : arr) {
                results = results * 10 + ele;
            }

            if (is_Prime(results)) {
                System.out.println(results);
            }
        }
    }


    public boolean is_Prime(int n) {
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i < Math.sqrt(n) + 1; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Q41().solver();
    }
}
