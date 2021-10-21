public class PrimalityTest {
    public static void main(String[] args) {
        int x = 11;
        boolean simple = true;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if  (x % i == 0) {
                simple = false;
            }
        }
        System.out.println(simple);
    }
}
