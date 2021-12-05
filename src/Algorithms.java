import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sieveOfEratosthenes(13)));
        System.out.println(Arrays.toString(primes(13)));
        System.out.println(primeFactors(20));
        System.out.println("------------------------");

        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                for (int j = i+i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    private static int[] primes(int n){
        int kol = 0;
        boolean[] bool = sieveOfEratosthenes(n);
        for (int i = 2; i <= n; i++)
            if (bool[i] == true)
                kol += 1;
        int[] numbers = new int[kol];
        int a = 0;
        for (int i = 2; i <= n; i++)
            if (bool[i] == true) {
                numbers[a] = i;
                a += 1;
            }
        return numbers;
    }

    private static List<List<Integer>> primeFactors(int n){
        List<List<Integer>> factor = new ArrayList<>();
        int[] prime = primes(n);
        double n1 = n;
        int d = 0;
        for (int x : prime){
            while (n1 % x == 0){
                n1 = n1 / x;
                d += 1;
            }
            if (d != 0) {
                List<Integer> a = new ArrayList<>();
                a.add(x);
                a.add(d);
                factor.add(a);
                //factor.add(x);
            }
            d = 0;
        }
        return factor;
    }

    public static int binarySearch(int[] a, int value) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2; //середина диапазона
            //проверить a[m] и понять, где искать дальше, слева или справа от m
            if (a[m] == value)
                return m;
            else if (a[m] > value)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    private static void test(int[] a, int value, int correctAnswer) {
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println("Got " + actualAnswer + " instead of " + correctAnswer);
    }
}
