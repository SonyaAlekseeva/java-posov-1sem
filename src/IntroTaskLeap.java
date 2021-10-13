public class IntroTaskLeap {//дан год, определить, високосный или нет
    public static void main(String[] args) {
        int x = 11;
        boolean a = (x % 4 == 0) & (x % 100 != 0) || (x % 400 == 0);
        System.out.println(a);
    }
}
