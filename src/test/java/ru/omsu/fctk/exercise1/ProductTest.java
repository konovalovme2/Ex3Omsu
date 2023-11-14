package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testEquals() {
        Product a = new Product("Лапша","Сухая");
        Product b = new Product("Лапша","Сухая");
        Product c = new Product("Подарок","Сладкий");

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void testHashCode() {
        Product a = new Product("Лапша","Сухая");
        Product b = new Product("Лапша","Сухая");
        Product c = new Product("Подарок","Сладкий");

        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
    }

    @Test
    public void testToString() {
        Product a = new Product("Огурцы","Солёные");
        Product c = new Product("Подарок","Сладкий");

        assertEquals("Название товара: Огурцы\nОписание товара: Солёные\n",a.toString());
        assertEquals("Название товара: Подарок\nОписание товара: Сладкий\n",c.toString());
    }
}