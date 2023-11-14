package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductPieceTest {

    @Test
    public void testHashCode() {
        ProductPiece a = new ProductPiece("Лапша",129,"Сухая");
        ProductPiece b = new ProductPiece("Лапша",129,"Сухая");
        ProductPiece c = new ProductPiece("Лапша",139,"Сухая");



        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(c.hashCode(), b.hashCode());
    }

    @Test
    public void testEquals() {
        ProductPiece a = new ProductPiece("Лапша",129,"Сухая");
        ProductPiece b = new ProductPiece("Лапша",129,"Сухая");
        ProductPiece c = new ProductPiece("Лапша",139,"Сухая");

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void testToString() {
        ProductPiece a = new ProductPiece("Лапша",129,"Cухая");
        ProductPiece c = new ProductPiece("Огурцы",139,"Солёные");

        assertEquals("Название товара: Лапша\nМасса одной единицы товара: 129.0\nОписание товара: Cухая\n",a.toString());
        assertEquals("Название товара: Огурцы\nМасса одной единицы товара: 139.0\nОписание товара: Солёные\n",c.toString());
    }
}