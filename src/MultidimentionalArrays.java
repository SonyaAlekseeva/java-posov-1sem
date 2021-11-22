import java.util.Arrays;

public class MultidimentionalArrays {
    public static void main(String[] args){
        int[][] a = new int[][]{
                {10, 1, 100_000, 44, 4244},
                {111, 432, 44},
                {5, 27, 1, 33, 123523, 6}
        };
        printTableInt(a);
        System.out.println("----------------------------------------");
        printTableAligned(a);

        System.out.println("----------------------------------------");
        char[][] c = createTable(20, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
    }

    public static void printTableInt(int[][] a) {
        String sep_line = "";
        for (int[] line : a) {
            for (int x : line)
                sep_line = sep_line + x + " ";
            System.out.println(sep_line);
            sep_line = "";
        }
    }

    public static void printTableAligned(int[][] a) {
        int max_len = 0;
        for (int i = 0; i <= a.length - 1; i++)
            if (a[i].length > max_len)
                    max_len = a[i].length;
        int[] help_len = new int[max_len];
        for (int[] line : a) {
            for (int i = 0; i < line.length; i++) {
                if (String.valueOf(line[i]).length() > help_len[i])
                    help_len[i] = String.valueOf(line[i]).length();
            }
        }
        //System.out.println(Arrays.toString(help_len));
        for (int[] line : a) {
            String sep_line = "";
            for (int i = 0; i <= line.length - 1; i++){
                int k = help_len[i] - String.valueOf(line[i]).length();
                for (int j = 1; j <= k; j++)
                    sep_line = sep_line + " ";
                if (i != 0)
                    sep_line = sep_line + " ";
                sep_line = sep_line + line[i];
            }
            System.out.println(sep_line);
        }
    }

    public static char[][] createTable(int n, char sym) {
        char[][] a = new char[n][n];
        for (char[] line : a) {
            Arrays.fill(line, sym);
        }
        return a;
    }

    public static void printTable(char[][] a) {
        String sep_line = "";
        for (char[] line : a) {
            for (char x : line)
                sep_line = sep_line + x + " ";
            System.out.println(sep_line);
            sep_line = "";
        }
    }

    public static void fillFirstAndLastLines(char[][] a, char sym) {
        Arrays.fill(a[0], sym);
        Arrays.fill(a[a.length - 1], sym);
    }

    public static void fillFirstAndLastColumns(char[][] a, char sym) {
        for (char[] line : a) {
            line[0] = sym;
            line[line.length - 1] = sym;
        }
    }
}
