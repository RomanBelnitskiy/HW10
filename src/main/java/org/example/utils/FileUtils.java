package org.example.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileUtils {
    private static String[] readLinesFrom(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[1024];
            int readChars;

            while ((readChars = fileReader.read(buffer)) > 0) {
                stringBuilder.append(buffer, 0, readChars);
            }

            return stringBuilder.toString().split(System.lineSeparator());
        } catch (IOException e) {
            return new String[0];
        }
    }
    private static void writeStringTo(File file, String data) {
        Objects.requireNonNull(file);
        Objects.requireNonNull(data);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.append(data);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] loadDataFromFile(String fileName) {
        File file = new File(fileName);
        return FileUtils.readLinesFrom(file);
    }

    public static void writeDataToFile(String fileName, String data) {
        File file = new File(fileName);
        FileUtils.writeStringTo(file, data);
    }
}
