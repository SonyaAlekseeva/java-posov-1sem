public class IntroTaskCat {//приписать "кот" в правильной форме
    public static void main(String[] args) {
        int x = 11;
        String s = "котов";
        if (x % 10 == 1 && x % 100 != 11)
            s = "кот";
        else if (((x % 10 == 2) || (x % 10 == 3) || (x % 10 == 4)) && (x % 100 / 10 != 1))
            s = "кота";
        System.out.println(x + " " + s);
    }
}
