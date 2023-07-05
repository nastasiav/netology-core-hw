package hw3.work3;

import hw3.work2.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        openZip("//Users//asya//admin//Games//savegames//zipGames.zip");
        System.out.println(openProgress("//Users//asya//admin//Games//savegames//gameProgress1.dat"));
    }

    private static void openZip(String path) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(path))) {
            ZipEntry entry;
            String name;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fileOutputStream = new FileOutputStream(name);
                for (int el = zipInputStream.read(); el != -1; el = zipInputStream.read()) {
                    fileOutputStream.write(el);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static GameProgress openProgress(String path) {
        GameProgress gameProgress = null;
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream)) {
            gameProgress = (GameProgress) objInputStream.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return gameProgress;
    }
}
