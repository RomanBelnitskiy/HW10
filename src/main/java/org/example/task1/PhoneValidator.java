package org.example.task1;

import java.util.regex.Pattern;

public class PhoneValidator {
    private static final String REGEXP = "^\\(?\\d{3}\\)?[- ]?\\d{3}-\\d{4}$";
    private final Pattern pattern;

    public PhoneValidator() {
        pattern = Pattern.compile(REGEXP);
    }

    public boolean validate(String phone) {
        return pattern.matcher(phone).matches();
    }
}
