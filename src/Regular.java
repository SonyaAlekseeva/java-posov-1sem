import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args){
        //String line = "sonelex8@yandex.ru";
        System.out.println(email("sonelex8@yandex.ru"));
        System.out.println(email("sonelex@yandex.commit"));
        System.out.println(email("SO8@yandex.ru"));
        System.out.println(email("sonelex8@yan1111dex.ru"));
        System.out.println("------------------------");

        System.out.println(email2("sonelex8@yandex.ru"));
        System.out.println(email2("sonelex@yandex.commit"));
        System.out.println(email2("SO8@yandex.ru"));
        System.out.println(email2("sonelex8@yan1111dex.ru"));
        System.out.println("------------------------");

        String text = "В 12:10 поезд выехал из Кирова. В 27:45 он прибудет в Москву";
        timeCheck(text);
        System.out.println("------------------------");
        System.out.println(deleteSpace("Это строка  , у которой зачем-то написаны два пробела перед запятой."));
        System.out.println("------------------------");
        System.out.println(changeWordPlaces("Какая-то сине-зеленовая трава"));
        System.out.println("------------------------");
        System.out.println(cats("Кот, который живет на крыше, кот из подвала и мой КОТ что-то задумали"));
        System.out.println("------------------------");
        System.out.println(numberPlus("У меня 2 яблока и -4 банана"));
    }

    private static boolean email(String a){
        String e = "[a-z0-9_-]+@[a-z]+\\.[a-z]{2,4}";
        return a.matches(e);
    }

    private static boolean email2(String a){ //с выражением с сайта
        String e = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return a.matches(e); //почему-то ответы в email и email2 различаются. Причем, в функции email без выражения с сайта ответ точнее
    }

    private static void timeCheck(String a){
        for (int i = 0; i <= a.length() - 6; i++){
            String check = a.substring(i, i+5);
            if (check.matches("\\d\\d:\\d\\d")){
                String first = check.substring(0, 2);
                int f = Integer.parseInt(first);
                String second = check.substring(3, 5);
                int s = Integer.parseInt(second);
                boolean t = (0 <= f && f <= 24 && 0 <= s && s <= 59);
                System.out.println(check + " " + t);
            }
        }
    }

    private static String deleteSpace(String a){
        return a.replaceAll("\\s+,", ",");
    }

    private static String changeWordPlaces(String a){
        return a.replaceAll("([А-Яа-я]+)-([А-Яа-я]+)", "$2-$1");
    }

    private static int cats(String a){
        int n = 0;
        Pattern timePattern = Pattern.compile("кот\\b", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        Matcher m = timePattern.matcher(a);
        while (m.find()) {
            n ++;
        }
        return n;
    }

    private static String numberPlus(String a){
        Pattern timePattern = Pattern.compile("(-?+\\d+)");
        Matcher m = timePattern.matcher(a);
        while (m.find()) {
            int f = Integer.parseInt(m.group()) + 1;
            a = a.replaceAll(m.group(), String.valueOf(f));
        }
        return a;
    }
}
