package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductWeightTest
{
    @Test
    public void testEquals() {
        ProductWeight a = new ProductWeight("Лапша","Сухая");
        ProductWeight b = new ProductWeight("Лапша","Сухая");
        ProductWeight c = new ProductWeight("Подарок","Сладкий");

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void testHashCode() {
        ProductWeight a = new ProductWeight("Лапша","Сухая");
        ProductWeight b = new ProductWeight("Лапша","Сухая");
        ProductWeight c = new ProductWeight("Подарок","Сладкий");

        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
    }

    @Test
    public void testToString() {
        ProductWeight a = new ProductWeight("Огурцы","Солёные");
        ProductWeight c = new ProductWeight("Подарок","Сладкий");

        assertEquals("Название товара: Огурцы\nОписание товара: Солёные\n",a.toString());
        assertEquals("Название товара: Подарок\nОписание товара: Сладкий\n",c.toString());
    }
}