package hw3.work2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(100, 1, 1, 12);
        GameProgress gameProgress2 = new GameProgress(50, 2, 2, 222);
        GameProgress gameProgress3 = new GameProgress(25, 3, 15, 4355);

        saveGame("//Users//asya//admin//Games//savegames//gameProgress1.dat", gameProgress1);
        saveGame("//Users//asya//admin//Games//savegames//gameProgress2.dat", gameProgress2);
        saveGame("//Users//asya//admin//Games//savegames//gameProgress3.dat", gameProgress3);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("//Users//asya//admin//Games//savegames//gameProgress1.dat");
        arrayList.add("//Users//asya//admin//Games//savegames//gameProgress2.dat");
        arrayList.add("//Users//asya//admin//Games//savegames//gameProgress3.dat");

        zipFiles("//Users//asya//admin//Games//savegames//zipGames.zip", arrayList);

        File gameProgress1Data = new File("//Users//asya//admin//Games//savegames//gameProgress1.dat");
        File gameProgress2Data = new File("//Users//asya//admin//Games//savegames//gameProgress2.dat");
        File gameProgress3Data = new File("//Users//asya//admin//Games//savegames//gameProgress3.dat");

        if (gameProgress1Data.delete()) {
            System.out.println("Файл \"gameProgress1.dat\" удален");
        }
        if (gameProgress2Data.delete()) {
            System.out.println("Файл \"gameProgress2.dat\" удален");
        }
        if (gameProgress3Data.delete()) {
            System.out.println("Файл \"gameProgress3.dat\" удален");
        }
    }

    private static void saveGame(String path, GameProgress game) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void zipFiles(String path, List<String> arrayList) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (String arr : arrayList) {
                try (FileInputStream fis = new FileInputStream(arr)) {
                    ZipEntry entry = new ZipEntry(arr);
                    zout.putNextEntry(entry);
                    while (fis.available() > 0) {
                        zout.write(fis.read());
                    }
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}