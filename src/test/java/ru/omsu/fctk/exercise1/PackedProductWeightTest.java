package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackedProductWeightTest {

    @Test
    public void getWeightNetto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight one = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight two = new PackedProductWeight(b,prod2,14);
        PackedProductWeight three = new PackedProductWeight(c,prod1,236);

        assertEquals(one.getWeight(),one.getWeightNetto(),2);
        assertEquals(two.getWeight(),two.getWeightNetto(),2);
        assertEquals(three.getWeight(),three.getWeightNetto(),2);

    }

    @Test
    public void getWeightBrutto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight one = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight two = new PackedProductWeight(b,prod2,14);
        PackedProductWeight three = new PackedProductWeight(c,prod1,236);

        assertEquals(one.getWeightNetto() + a.getWeight(),one.getWeightBrutto(),2);
        assertEquals(two.getWeightNetto() + b.getWeight(),two.getWeightBrutto(),2);
        assertEquals(three.getWeightNetto() + c.getWeight(),three.getWeightBrutto(),2);
    }

    @Test
    public void testToString() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight one = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight two = new PackedProductWeight(b,prod2,14);
        PackedProductWeight three = new PackedProductWeight(c,prod1,236);

        assertEquals("Название упаковки: A\nМасса упаковки: 129.0\nНазвание товара: Лапша\nОписание товара: Сухая\nМасса товара в кг: 1.5\n",one.toString());
        assertEquals("Название упаковки: B\nМасса упаковки: 139.0\nНазвание товара: Подарок\nОписание товара: Сладкий\nМасса товара в кг: 14.0\n",two.toString());
        assertEquals("Название упаковки: \nМасса упаковки: 0.0\nНазвание товара: Лапша\nОписание товара: Сухая\nМасса товара в кг: 236.0\n",three.toString());
    }

    @Test
    public void testEquals() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("A",129);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");
        ProductWeight prod3 = new ProductWeight("Лапша","Сухая");

        PackedProductWeight one = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight two = new PackedProductWeight(b,prod2,14);
        PackedProductWeight three = new PackedProductWeight(c,prod3,1.5);

        assertTrue(one.equals(three));
        assertFalse(one.equals(two));
    }

    @Test
    public void testHashCode() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("A",129);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");
        ProductWeight prod3 = new ProductWeight("Лапша","Сухая");

        PackedProductWeight one = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight two = new PackedProductWeight(b,prod2,14);
        PackedProductWeight three = new PackedProductWeight(c,prod3,1.5);

        assertTrue(one.hashCode()==three.hashCode());
        assertFalse(one.hashCode()==two.hashCode());
    }
}