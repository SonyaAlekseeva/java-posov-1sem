public class IntroTaskSameDigits {//проверить, что у числа на конце 2 одинаковые цифры
    public static void main(String[] args) {
        int x = 11;
        boolean a = x % 10 == (x / 10) % 10;
        System.out.println(a);
    }
}
