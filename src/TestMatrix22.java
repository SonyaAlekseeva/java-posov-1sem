import java.util.Arrays;

public class TestMatrix22 {
    public static void main(String[] args) {
        Matrix22 t1 = new Matrix22(1, 2, 3, 4);
        Matrix22 t2 = new Matrix22(new double[][]{{1, 2}, {3, 4}});
        Matrix22 t3 = new Matrix22(-4.43, -2.111, 1, 67.999);

        System.out.println(t1.getTrace());
        System.out.println(t2.getTrace());
        System.out.println(t3.getTrace());

        System.out.println(t1.getDiscriminant());
        System.out.println(t2.getDiscriminant());
        System.out.println(t3.getDiscriminant());

        System.out.println(Arrays.deepToString(t1.getArray()));
        System.out.println(Arrays.deepToString(t2.getArray()));
        System.out.println(Arrays.deepToString(t3.getArray()));

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());

        t1.print();
        t2.print();
        t3.print();

        System.out.println((t1.add(t2)));
        System.out.println((t1.mul(t2)));
        System.out.println(t1.pow(2));

        System.out.println(fib(5));
        System.out.println(fib(8));

        Matrix22 r = new Rotation(30);
        System.out.println(((Rotation) r).getAngle());
    }

    public static double fib(int n) {
        Matrix22 f = new Matrix22(1, 1, 1, 0);
        f = f.pow(n-1);
        return f.a;
    }
}
