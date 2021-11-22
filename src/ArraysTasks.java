import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args){
        int[] t1 = even(5);
        System.out.println(Arrays.toString(t1));
        int[] t2 = {1, 2, 6, 2};
        System.out.println(allSimilar(t2));
        System.out.println(hasSimilar(t2));
        int[] t4 = {10, 20, 30, 3};
        System.out.println(mean(t4));
        int[] t5 = {10, 20, 30, 40};
        shift(t5);
        System.out.println(Arrays.toString(t5));
        int[] t6 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(copyShift(t6)));
    }

    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 1; i <= n; i++)
            a[i-1] = 2 * i;
        return a;
    }

    private static boolean allSimilar(int[] a) {
        for (int i = 1; i <= a.length - 1; i++)
            if (a[0] != a[i])
                return false;
        return true;
    }

    private static boolean hasSimilar(int[] a) {
        for (int i = 0; i <= a.length - 1; i++ )
            for (int j = i+1; j <= a.length - 1; j++)
                if (a[i] == a[j])
                    return true;
        return false;
    }

    private static double mean(int[] a) {
        double s = a[0];
        for (int i = 1; i <= a.length - 1; i++)
            s = s + a[i];
        return (s/(a.length));
    }

    private static void shift(int[] a) {
        int l = a.length - 1;
        int end = a[l];
        for (int i = l; i >= 1 ; i--)
            a[i] = a[i-1];
        a[0] = end;
    }

    private static int[] copyShift(int[] a) {
        int l = a.length - 1;
        int[] b = new int[l+1];
        for (int i = 0; i <= l-1; i++)
            b[i+1] = a[i];
        b[0] = a[l];
        return b;
    }
}
