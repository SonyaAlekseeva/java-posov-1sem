public class IntroTaskQuadraticEquation {//решить квадратное уравнение
    public static void main(String[] args) {
        double a = 3, b = -8, c = 5;
        double d = b * b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.println("Решений бесконечно много");
                else
                    System.out.println("Решений нет");
            }
            else
                System.out.println(String.format("Одно решение: x = %.2f", -c/b));
        }
        else {
            if (d < 0)
                System.out.println("Решений нет");
            else if (d == 0)
                System.out.println(String.format("Одно решение: x = %.2f", (-b/(2*a))));
            else if (d > 0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.println("Два решения: x1 = " + String.format("%.2f",Math.min(x1, x2)) + ", x2 = " + String.format("%.2f",Math.max(x1, x2)));
            }
        }
    }
}
