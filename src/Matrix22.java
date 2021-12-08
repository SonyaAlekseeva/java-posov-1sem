public class Matrix22 {
    public double a, b, c, d;

    Matrix22(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    Matrix22 (double[][] array) {
        this.a = array[0][0];
        this.b = array[0][1];
        this.c = array[1][0];
        this.d = array[1][1];
    }

    public double getTrace(){
        return a + d;
    }

    public double getDiscriminant(){
        return a * d - b * c;
    }

    public double[][] getArray() {
        double[][] array = new double[][] {
                {a, b},
                {c, d}
        };
        return array;
    }

    public String toString() {
        return a + " " + b + " " + c + " " + d;
    }

    public void print() {
        String a1 = Double.toString(a);
        String c1 = Double.toString(c);
        String l1 = a1;
        String l2 = c1;
        int n;
        if (a1.length() > c1.length()) {
            n = a1.length() - c1.length();
            l1 += " " + b;
            for (int i = 0; i <= n; i++) {
                l2 += " ";
            }
            l2 += Double.toString(d);
        }
        else {
            n = c1.length() - a1.length();
            l2 += " " + d;
            for (int i = 0; i <= n; i++) {
                l1 += " ";
            }
            l1 += Double.toString(b);
        }
        System.out.println(l1);
        System.out.println(l2);
    }

    public Matrix22 add(Matrix22 y) {
        double xa = a + y.a;
        double xb = b + y.b;
        double xc = c + y.c;
        double xd = d + y.d;
        Matrix22 x = new Matrix22(xa, xb, xc, xd);
        return x;
    }

    public Matrix22 mul(Matrix22 y) {
        double xa = a * y.a + b * y.c;
        double xb = a * y.b + b * y.d;
        double xc = c * y.a + d * y.c;
        double xd = c * y.b + d * y.d;
        Matrix22 x = new Matrix22(xa, xb, xc, xd);
        return x;
    }

    public Matrix22 pow(int n) {
        Matrix22 x = this;
        Matrix22 y = this;
        for (int i = 0; i < n-1; i++) {
            x = x.mul(y);
            System.out.println(x);
        }
        return x;
    }

}
