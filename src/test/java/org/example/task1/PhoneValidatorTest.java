package org.example.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorTest {
    private PhoneValidator validator;

    @BeforeEach
    void init() {
        validator = new PhoneValidator();
    }

    @Test
    void testPhoneInDashedFormat() {
        boolean isValid = validator.validate("987-123-4567");
        assertTrue(isValid);
    }

    @Test
    void testPhoneInBracketDashedFormat() {
        boolean isValid = validator.validate("(987) 123-4567");
        assertTrue(isValid);
    }

    @Test
    void testPhoneInNotValidFormat() {
        boolean isValid = validator.validate("987 123 4567");
        assertFalse(isValid);
    }
}