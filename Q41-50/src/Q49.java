
import java.util.ArrayList;

public class Q49 {

    private ArrayList<Integer> PRIMES = new ArrayList<>();

    Q49(){
        System.out.println("What 12-digit number do you form by concatenating the three terms in this sequence?");
    }

    /*
        Properties:

            1. 4 digits
            2. the same increment
            3. Prime
            4. IsPermutation

     */
    public void solver(){
        generatePrimes();
        for(int i = 0; i <= PRIMES.size()-1; i++){
            for(int j = i+1; j <= PRIMES.size()-1;j++){
                int num1 = PRIMES.get(i);
                int num2 = PRIMES.get(j);
                if(isPermutation(num1,num2)){
                    int increment = num2-num1;
                    int num3 = num2+increment;
                    if(isPrime(num3) && isPermutation(num3,num2) && num1!=1487){
                        System.out.println(num1);
                        System.out.println(num2);
                        System.out.println(num3);
                        System.out.println(Integer.toString(num1)+Integer.toString(num2)+Integer.toString(num3));
                        return;
                    }
                }

            }
        }

    }


    public void generatePrimes() {
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                PRIMES.add(i);
            }
        }

    }

    private boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPermutation(int a, int b){
        String temp1 = Integer.toString(a);
        String temp2 = Integer.toString(b);
        if(temp1.length() != temp2.length()) return false;

        for(char ele: temp1.toCharArray()){
            if(!temp2.contains(ele+"")) return false;
        }

        for(char ele: temp2.toCharArray()){
            if(!temp1.contains(ele+"")) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Q49().solver();
        System.out.println();
    }

}

