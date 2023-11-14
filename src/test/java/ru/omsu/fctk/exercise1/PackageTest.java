package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackageTest {

    @Test
    public void testHashCode() {
        Package a = new Package("A",129);
        Package b = new Package("A",129);
        Package c = new Package("B",139);

        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
    }

    @Test
    public void testEquals() {
        Package a = new Package("A",129);
        Package b = new Package("A",129);
        Package c = new Package("B",139);

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void testToString() {
        Package a = new Package("A",129);
        Package c = new Package("B",139);

        assertEquals("Название упаковки: A\nМасса упаковки: 129.0\n",a.toString());
        assertEquals("Название упаковки: B\nМасса упаковки: 139.0\n",c.toString());
    }
}