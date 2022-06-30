package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTester {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("D:\\University\\Math"), new FileManager());
        Files.walkFileTree(Path.of("D:\\University\\Art"), new FileManager());
    }
}
