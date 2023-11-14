package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackedProductPieceTest {

    @Test
    public void getWeightNetto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductPiece prod1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece prod2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece one = new PackedProductPiece(a,prod1,15);
        PackedProductPiece two = new PackedProductPiece(b,prod2,14);
        PackedProductPiece three = new PackedProductPiece(c,prod1,236);

        assertEquals(prod1.getWeight()*one.getPiece(),one.getWeightNetto(),2);
        assertEquals(prod2.getWeight()*two.getPiece(),two.getWeightNetto(),2);
        assertEquals(prod1.getWeight()*three.getPiece(),three.getWeightNetto(),2);

    }

    @Test
    public void getWeightBrutto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductPiece prod1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece prod2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece one = new PackedProductPiece(a,prod1,15);
        PackedProductPiece two = new PackedProductPiece(b,prod2,14);
        PackedProductPiece three = new PackedProductPiece(c,prod1,236);

        assertEquals(prod1.getWeight()*one.getPiece() + a.getWeight()*one.getPiece(),one.getWeightBrutto(),2);
        assertEquals(prod2.getWeight()*two.getPiece() + b.getWeight()*two.getPiece(),two.getWeightBrutto(),2);
        assertEquals(prod1.getWeight()*three.getPiece() + c.getWeight()*three.getPiece(),three.getWeightBrutto(),2);
    }

    @Test
    public void testToString() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductPiece prod1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece prod2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece one = new PackedProductPiece(a,prod1,15);
        PackedProductPiece two = new PackedProductPiece(b,prod2,14);
        PackedProductPiece three = new PackedProductPiece(c,prod1,236);

        assertEquals("Название упаковки: A\nМасса упаковки: 129.0\nНазвание товара: Лапша\nМасса одной единицы товара: 1.5\nОписание товара: Сухая\nКол-во товара в шт.: 15\n",one.toString());
        assertEquals("Название упаковки: B\nМасса упаковки: 139.0\nНазвание товара: Подарок\nМасса одной единицы товара: 0.0\nОписание товара: Сладкий\nКол-во товара в шт.: 14\n",two.toString());
        assertEquals("Название упаковки: \nМасса упаковки: 0.0\nНазвание товара: Лапша\nМасса одной единицы товара: 1.5\nОписание товара: Сухая\nКол-во товара в шт.: 236\n",three.toString());
    }

    @Test
    public void testEquals() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("A",129);

        ProductPiece prod1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece prod2 = new ProductPiece("Подарок",0,"Сладкий");
        ProductPiece prod3 = new ProductPiece("Лапша",1.5,"Сухая");

        PackedProductPiece one = new PackedProductPiece(a,prod1,15);
        PackedProductPiece two = new PackedProductPiece(b,prod2,14);
        PackedProductPiece three = new PackedProductPiece(c,prod3,15);

        assertTrue(one.equals(three));
        assertFalse(one.equals(two));
    }

    @Test
    public void testHashCode() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("A",129);

        ProductPiece prod1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece prod2 = new ProductPiece("Подарок",0,"Сладкий");
        ProductPiece prod3 = new ProductPiece("Лапша",1.5,"Сухая");

        PackedProductPiece one = new PackedProductPiece(a,prod1,15);
        PackedProductPiece two = new PackedProductPiece(b,prod2,14);
        PackedProductPiece three = new PackedProductPiece(c,prod3,15);

        assertTrue(one.hashCode()==three.hashCode());
        assertFalse(one.hashCode()==two.hashCode());
    }
}