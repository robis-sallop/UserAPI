package cl.rsalinas.api.util;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    public static void main(String[] args) {
        System.out.println("EMAIL VALIDO? "+Validator.validateEmail("juan@gmail.com"));

        System.out.println("PASSWORD VALIDO? "+Validator.validatePassword("Adfsf123"));
    }
}