package ru.omsu.fctk.exercise1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsignmentOfGoodsTest {

    @Test
    public void getWeightBrutto() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"B",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(c,"C");

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", oneWeight, threePiece,three);
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", threeWeight, twoPiece,three);

        assertEquals(0,party2.getWeightBrutto(),2);
        assertEquals(oneWeight.getWeightBrutto()+threePiece.getWeightBrutto()+three.getWeightBrutto(),party1.getWeightBrutto(),2);
    }

    @Test
    public void testToString() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"A",oneWeight,twoWeight,onePiece,twoPiece);

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", twoWeight, one,onePiece);

        assertEquals("Описание партии товаров: В Москву\n" +
                "{[Название упаковки: B\n" +
                "Масса упаковки: 0.0\n" +
                "Название товара: Подарок\n" +
                "Описание товара: Сладкий\n" +
                "Масса товара в кг: 14.0\n" +
                "][Название упаковки: \n" +
                "Масса упаковки: 0.0\n" +
                "Название набора: A\n" +
                "{[Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название товара: Лапша\n" +
                "Описание товара: Сухая\n" +
                "Масса товара в кг: 1.5\n" +
                "][Название упаковки: B\n" +
                "Масса упаковки: 0.0\n" +
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
                "Масса упаковки: 0.0\n" +
                "Название товара: Подарок\n" +
                "Масса одной единицы товара: 0.0\n" +
                "Описание товара: Сладкий\n" +
                "Кол-во товара в шт.: 14\n" +
                "]}][Название упаковки: A\n" +
                "Масса упаковки: 129.0\n" +
                "Название товара: Лапша\n" +
                "Масса одной единицы товара: 1.5\n" +
                "Описание товара: Сухая\n" +
                "Кол-во товара в шт.: 15\n" +
                "]}",party1.toString());
    }

    @Test
    public void testHashCode() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"B",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(c,"C");

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", oneWeight, threePiece,three);
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", threeWeight, twoPiece,three);
        ConsignmentOfGoods party3 = new ConsignmentOfGoods("В Санкт-Петербург", threeWeight, twoPiece,three);

        assertFalse(party1.hashCode()==party3.hashCode());
        assertTrue(party3.hashCode()==party2.hashCode());
    }

    @Test
    public void testEquals() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Лапша","Сухая");
        ProductWeight prod2 = new ProductWeight("Подарок","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("Лапша",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"A",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"B",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(c,"C");

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", oneWeight, threePiece,three);
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", threeWeight, twoPiece,three);
        ConsignmentOfGoods party3 = new ConsignmentOfGoods("В Санкт-Петербург", threeWeight, twoPiece,three);

        assertTrue(party3.equals(party2));
        assertFalse(party1.equals(party2));
    }
}