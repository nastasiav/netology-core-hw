package hw3.work1;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        List<File> folderList = Arrays.asList(
                new File("//Users//asya//admin//Games"),
                new File("//Users//asya//admin//Games//temp"),
                new File("//Users//asya//admin//Games//src"),
                new File("//Users//asya//admin//Games//res"),
                new File("//Users//asya//admin//Games//savegames"),
                new File("//Users//asya//admin//Games//src//main"),
                new File("//Users//asya//admin//Games//src//test"),
                new File("//Users//asya//admin//Games//res//drawables"),
                new File("//Users//asya//admin//Games//res//vectors"),
                new File("//Users//asya//admin//Games//res//icons"));

        List<File> fileList = Arrays.asList(
                new File("//Users//asya//admin//Games//src//main//Main.java"),
                new File("//Users//asya//admin//Games//src//main//Utils.java"),
                new File("//Users//asya//admin//Games//temp//temp.txt"));

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) {
                sb.append("Каталог " + folder + " создан\n");
            }
            else {
                sb.append("Каталог " + folder + " не создан\n");
            }
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) {
                    sb.append("Файл " + file + " создан\n");
                }
                else {
                    sb.append("Файл " + file + " не создан\n");
                }
            } catch (IOException e) {
                System.err.println("error creating");
            }
        });

        try (FileWriter log = new FileWriter("//Users//asya//admin//Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            System.err.println("error log");
        }
        try (
                BufferedReader br = new BufferedReader(new FileReader("//Users//asya//admin//Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
