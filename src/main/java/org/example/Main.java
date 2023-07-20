package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//        readingBlockFromByteArray();
//        readingBigBlockFromByteArray();
//        writeToByteArray();

//        readFromCharArray();
//        readingBlockFromCharArray();
        writeToCharArray();
    }

    private static void writeToCharArray() {
        CharArrayWriter caw = new CharArrayWriter();

        caw.append("I like Java");
        caw.flush();
        char[] chars = caw.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        caw.close();
    }

    private static void readingBlockFromCharArray() throws IOException {
        char[] chars = new char[] {'I', ' ', 'l', 'i', 'k', 'e', ' ', 'J', 'a', 'v', 'a'};
        CharArrayReader car = new CharArrayReader(chars);

        char[] buffer = new char[1024];

        int readChars = car.read(buffer, 0, buffer.length);

        for (int i = 0; i < readChars; i++) {
            System.out.print(buffer[i]);
        }

        car.close();
    }

    private static void readFromCharArray() throws IOException {
        char[] chars = new char[] {'I', ' ', 'l', 'i', 'k', 'e', ' ', 'J', 'a', 'v', 'a'};
        CharArrayReader car = new CharArrayReader(chars);

        int nextChar;
        while ((nextChar = car.read()) != -1) {
            System.out.print((char) nextChar);
        }
        car.close();
    }

    private static void writeToByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        for (int i = 0; i < 20; i++) {
            baos.write(i);
        }
        baos.flush();

        baos.close();
        System.out.println("Arrays.toString(baos.toByteArray()) = " + Arrays.toString(baos.toByteArray()));
    }

    public static void readingBigBlockFromByteArray() throws IOException {
        byte[] bytes = {1, 3, 5, 7, 8, 9, 15, 1, 3, 5, 7, 8, 9, 15, 1, 3, 5, 7, 8, 9, 15, 1, 3, 5, 7, 8, 9, 15, 1, 3, 5, 7, 8, 9, 15};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        int available = bais.available();
        System.out.println("available = " + available);

        byte[] buffer = new byte[10];
        int c;
        while ((c = bais.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                System.out.print(buffer[i] + ", ");
            }
        }
        bais.close();


    }

    public static void readingBlockFromByteArray() throws IOException {
        byte[] bytes = {1, 3, 5, 7, 8, 9, 15};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        int available = bais.available();
        System.out.println("available = " + available);

        byte[] buffer = new byte[available];
        int readBytes = bais.read(buffer);
        System.out.println("readBytes = " + readBytes);
        bais.close();

        for (int i = 0; i < buffer.length; i++) {
            System.out.println(buffer[i]);
        }
    }

    public static void readingFromByteArray() throws IOException {
        byte[] bytes = {1, 3, 5, 7, 9, 11};
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        int c;

        while ((c = bis.read()) != -1) {
            byte current = (byte) c;
            System.out.print(current + ", ");
        }

        bis.close();
    }
}