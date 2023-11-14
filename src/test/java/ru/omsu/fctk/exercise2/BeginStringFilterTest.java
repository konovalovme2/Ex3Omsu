package ru.omsu.fctk.exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeginStringFilterTest {

    @Test
    public void apply() {
        BeginStringFilter a = new BeginStringFilter("");
        BeginStringFilter b = new BeginStringFilter("Мама мыла раму");

        assertTrue(b.apply("Мама"));
        assertFalse(b.apply("мыла"));
        assertTrue(a.apply(""));
        assertFalse(a.apply("Мама"));
    }
}