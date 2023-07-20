package org.example.task1;

import org.example.utils.FileUtils;

public class PhoneNumberPrinter {
    public static void loadAndPrintValidPhoneNumbers(String fileName) {
        String[] phoneNumbers = FileUtils.loadDataFromFile(fileName);
        PhoneValidator validator = new PhoneValidator();

        for (String number : phoneNumbers) {
            if (validator.validate(number)) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        loadAndPrintValidPhoneNumbers("./files/phoneNumbers.txt");
    }
}
