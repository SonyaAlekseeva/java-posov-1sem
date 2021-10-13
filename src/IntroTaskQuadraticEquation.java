public class IntroTaskQuadraticEquation {//решить квадратное уравнение
    public static void main(String[] args) {
        int a = 4, b = -6, c = 3;
        int d = b * b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.println("Решений бесконечно много");
                else
                    System.out.println("Решений нет");
            }
            else
                System.out.println("Одно решение");
        }
        else {
            if (d < 0)
                System.out.println("Решений нет");
            else if (d == 0)
                System.out.println("Одно решение");
            else if (d > 0) {
//                int x1 = (-b - d * * 0.5) /(2 * a);
                //              int x2 = (-b + d * * 0.5) /(2 * a);
//            return f'два решения x1 = {min(x1,x2) :.2f}, x2 = {max(x1,x2) :.2f}'
                System.out.println("Два решения");
            }
        }
    }
}
