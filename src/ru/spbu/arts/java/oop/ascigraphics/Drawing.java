package ru.spbu.arts.java.oop.ascigraphics;

import java.util.Arrays;

public class Drawing {
    public int x, y;
    public char symbol;
    public char[][] massive;

    Drawing (int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        char[][] m = new char[y][x];
        this.massive = m;
        for (char[] line : this.massive) {
            Arrays.fill(line, symbol);
        }
    }

    public void print() {
        String sep_line = "";
        for (char[] line : massive) {
            for (char x : line)
                sep_line = sep_line + x + " ";
            System.out.println(sep_line);
            sep_line = "";
        }
    }

    public void setPoint(int a, int b, char sym) {
        massive[b][a] = sym;
    }

    public void drawVerticalLine(int a, int b1, int b2, char sym) {
        int y1 = Math.min(b1, b2);
        int y2 = Math.max(b1, b2);
        for (int i = y1; i <= y2; i++)
            setPoint(a, i, sym);
    }

    public void drawHorizontalLine(int a1, int a2, int b, char sym) {
        int x1 = Math.min(a1, a2);
        int x2 = Math.max(a1, a2);
        for (int i = x1; i <= x2; i++)
            setPoint(i, b, sym);
    }

    public void drawRectangle(int a1, int b1, int a2, int b2, char sym) {
        int x1 = Math.min(a1, a2);
        int x2 = Math.max(a1, a2);
        int y1 = Math.min(b1, b2);
        int y2 = Math.max(b1, b2);
        for (int i = x1; i <= x2; i++)
            drawVerticalLine(i, y1, y2, sym);
    }

    public void drawCircle(int rx, int ry, int r, char sym) {
        for  (int j = 0; j < y; j++){
            for (int i = 0; i < x; i++) {
                if ((rx-i)*(rx-i) + (ry-j)*(ry-j) <= r*r) {
                    setPoint(i, j, sym);
                }
            }
        }
    }

    public void draw(int a, int b, Drawing d) {
        int row = d.massive.length;
        int col = d.massive[0].length;
        for  (int j = 0; j < row; j++){
            for (int i = 0; i < col; i++) {
                    setPoint(a+i, b+j, d.massive[j][i]);
            }
        }
    }

    private void drawHouse() {

    }

}
