package ru.omsu.fctk.exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordFilterTest {

    @Test
    public void apply() {
        PasswordFilter a = new PasswordFilter();

        assertTrue(a.apply("qWvOgvY47CkmpteUa"));
        assertFalse(a.apply(""));
        assertFalse(a.apply("f l"));
        assertFalse(a.apply("\\||\\[[]]]@%@!^*"));
    }
}