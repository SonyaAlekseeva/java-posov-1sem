package ru.spbu.arts.java.collections;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class Collections {
    public static void main (String[] args) throws Exception {
        System.out.println(count(8));
        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);
        printListWithIndices(list1);
        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        //сначала чистая функция
        List<String> list5rev = reverseList(list5);
        //проверяем, что list5rev перевернутый, а list5 остался без изменений
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        //теперь функция, которая меняет сам список
        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
        System.out.println("ints = " + ints);
        //функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
        System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
        //функция должна удалить четные числа
        System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]

        // В этой части мы проделаем то же самое, но с функциями, которые изменяют переданные списки.
        // слово mutable означает "изменяемый", потому что в этой части мы будем использовать списки,
        // которые можно изменять.
        System.out.println(" ============= mutable lists =================== ");
        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts); //[22, 55, 88, 3]

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        doReadWordsInFile("collect-file.txt", hashSet);
        doReadWordsInFile("collect-file.txt", linkedHashSet);
        doReadWordsInFile("collect-file.txt", treeSet);
    }

    public static List<Integer> count(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        return list;
    }

    public static void printList(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (String i: list)
            System.out.println(i);
    }

    public static void  printListWithIndices(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (int i = 1; i <= list.size(); i++)
            System.out.println(i + ": " + list.get(i-1));
    }

    public static List<String> concatenateLists(List<String> l1, List<String> l2) {
        List<String> list = new ArrayList<>(l1);
        list.addAll(l2);
        return list;
    }

    private static List<String> reverseList(List<String> list) {
        List<String> rev = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            rev.add(list.get(i));
        return rev;
    }

    public static void reverseListInPlace(List<String> list) {
        int j = list.size() - 1;
        for (int i = 0; i < j; i++)
            list.add(i, list.remove(j));
    }

    public static List<Integer> filterEvenIndices(List<Integer> list) {
        List<Integer> s = new ArrayList<>();
        for (int i = 1; i < list.size(); i+=2)
            s.add(list.get(i));
        return s;
    }

    public static List<Integer> filterEven(List<Integer> list) {
        List<Integer> s = new ArrayList<>();
        for (Integer i: list)
            if (i % 2 != 0)
                s.add(i);
        return s;
    }

    /*
    public static void mutableFilterEvenIndices(List<Integer> list) {
        int i = 0;
        int k = 0;
        while (i != list.size()) {
            if (k % 2 == 0)
                list.remove(i);
            else
                i += 1;
            k += 1;
        }
    }
    */

    public static void mutableFilterEvenIndices(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--)
            if (i % 2  == 0)
                list.remove(i);
    }

    public static void mutableFilterEven(List<Integer> list) {
        int i = 0;
        while (i != list.size())
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else
                i += 1;
    }

    private static void doReadWordsInFile(String name, Set<String> set) throws Exception {
        Path txt = Path.of(name);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                set.add(in.next().toLowerCase());
            }
            System.out.println(set);
        }
    }
}
