package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackedProductSetTest {

    @Test
    public void getWeightNetto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,236);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"Первый",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"Второй",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(a,"Третий");

        assertEquals(0,three.getWeightNetto(),2);
        assertEquals(oneWeight.getWeightBrutto()+twoWeight.getWeightBrutto()+onePiece.getWeightBrutto()+twoPiece.getWeightBrutto(),one.getWeightNetto(),2);
        assertEquals(one.getWeightBrutto()+threeWeight.getWeightBrutto()+threePiece.getWeightBrutto(),two.getWeightNetto(),2);
    }

    @Test
    public void getWeightBrutto() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,236);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"B",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(a,"c");
        PackedProductSet four = new PackedProductSet(c,"d");

        assertEquals(a.getWeight(),three.getWeightBrutto(),2);
        assertEquals(0,four.getWeightBrutto(),2);
        assertEquals(one.getWeightNetto()+a.getWeight(),one.getWeightBrutto(),2);
        assertEquals(two.getWeightNetto()+b.getWeight(),two.getWeightBrutto(),2);
    }

    @Test
    public void testToString() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,236);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"B",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(a,"C");

        assertEquals("Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название набора: A\n" +
                "{[Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название товара: Лапша\n" +
                "Описание товара: Сухая\n" +
                "Масса товара в кг: 1.5\n" +
                "][Название упаковки: B\n" +
                "Масса упаковки: 139.0\n" +
                "Название товара: Подарок\n" +
                "Описание товара: Сладкий\n" +
                "Масса товара в кг: 14.0\n" +
                "][Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название товара: Лапша\n" +
                "Масса одной единицы товара: 1.5\n" +
                "Описание товара: Сухая\n" +
                "Кол-во товара в шт.: 15\n" +
                "][Название упаковки: B\n" +
                "Масса упаковки: 139.0\n" +
                "Название товара: Подарок\n" +
                "Масса одной единицы товара: 0.0\n" +
                "Описание товара: Сладкий\n" +
                "Кол-во товара в шт.: 14\n" +
                "]}",one.toString());
        assertEquals("Название упаковки: B\n" +
                "Масса упаковки: 139.0\n" +
                "Название набора: B\n" +
                "{[" + "Название упаковки: A\n" +
                        "Масса упаковки: 129.0\n" +
                        "Название набора: A\n" +
                        "{[Название упаковки: A\n" +
                        "Масса упаковки: 129.0\n" +
                        "Название товара: Лапша\n" +
                        "Описание товара: Сухая\n" +
                        "Масса товара в кг: 1.5\n" +
                        "][Название упаковки: B\n" +
                        "Масса упаковки: 139.0\n" +
                        "Название товара: Подарок\n" +
                        "Описание товара: Сладкий\n" +
                        "Масса товара в кг: 14.0\n" +
                        "][Название упаковки: A\n" +
                        "Масса упаковки: 129.0\n" +
                        "Название товара: Лапша\n" +
                        "Масса одной единицы товара: 1.5\n" +
                        "Описание товара: Сухая\n" +
                        "Кол-во товара в шт.: 15\n" +
                        "][Название упаковки: B\n" +
                        "Масса упаковки: 139.0\n" +
                        "Название товара: Подарок\n" +
                        "Масса одной единицы товара: 0.0\n" +
                        "Описание товара: Сладкий\n" +
                        "Кол-во товара в шт.: 14\n" +
                        "]}"+
                "]"+ "[Название упаковки: \n" +
                "Масса упаковки: 0.0\n" +
                "Название товара: Лапша\n" +
                "Описание товара: Сухая\n" +
                "Масса товара в кг: 236.0\n" +
                "][Название упаковки: \n" +
                "Масса упаковки: 0.0\n" +
                "Название товара: Лапша\n" +
                "Масса одной единицы товара: 1.5\n" +
                "Описание товара: Сухая\n" +
                "Кол-во товара в шт.: 236\n]}",two.toString());

        assertEquals("Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название набора: C\n" +
                "{}",three.toString());
    }

    @Test
    public void testHashCode() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,236);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet three = new PackedProductSet(a,"A",threeWeight,twoWeight,onePiece,threePiece);
        PackedProductSet four = new PackedProductSet(c,"A");
        PackedProductSet five = new PackedProductSet(c,"A");

        assertTrue(one.hashCode()==two.hashCode());
        assertTrue(four.hashCode()==five.hashCode());
        assertFalse(one.hashCode()==three.hashCode());
        assertFalse(one.hashCode()==four.hashCode());
    }

    @Test
    public void testEquals() {
        Package a = new Package("A",129);
        Package b = new Package("B",139);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,236);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(a,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet three = new PackedProductSet(a,"A",threeWeight,twoWeight,onePiece,threePiece);
        PackedProductSet four = new PackedProductSet(c,"A");
        PackedProductSet five = new PackedProductSet(c,"A");

        assertTrue(one.equals(two));
        assertTrue(four.equals(five));
        assertFalse(one.equals(three));
        assertFalse(one.equals(four));
    }
}