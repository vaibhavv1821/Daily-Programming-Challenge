import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> primeFactorization(int N) {
        List<Integer> factors = new ArrayList<>();

        while (N % 2 == 0) {
            factors.add(2);
            N /= 2;
        }

        for (int i = 3; i <= Math.sqrt(N); i += 2) {

            while (N % i == 0) {
                factors.add(i);
                N /= i;
            }
        }

        if (N > 2) {
            factors.add(N);
        }

        return factors;
    }

    public static void main(String[] args) {
        int[] testCases = {18, 30, 49, 19, 64, 123456};

        for (int N : testCases) {
            System.out.println("Input: N = " + N);
            System.out.println("Output: " + primeFactorization(N));
        }
    }
}
