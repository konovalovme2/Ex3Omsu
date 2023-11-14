package ru.omsu.fctk.exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsEvenNumFilterTest {
    @Test
    public void apply() {
        IsEvenNumFilter a = new IsEvenNumFilter();

        assertTrue(a.apply("3254678343712472"));
        assertFalse(a.apply("1243256467"));
        assertFalse(a.apply(""));
        assertFalse(a.apply("12gt28335cf2"));
    }
}