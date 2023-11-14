package ru.omsu.fctk.exercise3;

import org.junit.Test;
import ru.omsu.fctk.exercise1.*;
import ru.omsu.fctk.exercise1.Package;

import static org.junit.Assert.*;

public class ProductServiceTest {

    @Test
    public void checkAllWeighted() {
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
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", oneWeight, twoWeight,threeWeight);

        ProductService l = new ProductService();

        assertTrue(l.checkAllWeighted(party2));
        assertFalse(l.checkAllWeighted(party1));
    }

    @Test
    public void countByFilter() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Lapsha","Сухая");
        ProductWeight prod2 = new ProductWeight("4775","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"Aceton",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"bor",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(c,"|?");

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", one, threePiece,oneWeight);
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", two, twoPiece);
        ConsignmentOfGoods party3 = new ConsignmentOfGoods("В Санкт-Петербург", three);

        ProductService l = new ProductService();

        assertEquals(2,l.countByFilter(party1));
        assertEquals(0,l.countByFilter(party2));
        assertEquals(0,l.countByFilter(party3));
    }

    @Test
    public void countByFilterDeep() {
        Package a = new Package("A",129);
        Package b = new Package("B",0);
        Package c = new Package("",0);

        ProductWeight prod1 = new ProductWeight("Lapsha","Сухая");
        ProductWeight prod2 = new ProductWeight("4775","Сладкий");

        PackedProductWeight oneWeight = new PackedProductWeight(a,prod1,1.5);
        PackedProductWeight twoWeight = new PackedProductWeight(b,prod2,14);
        PackedProductWeight threeWeight = new PackedProductWeight(c,prod1,0);

        ProductPiece productPiece1 = new ProductPiece("",1.5,"Сухая");
        ProductPiece productPiece2 = new ProductPiece("Подарок",0,"Сладкий");

        PackedProductPiece onePiece = new PackedProductPiece(a,productPiece1,15);
        PackedProductPiece twoPiece = new PackedProductPiece(b,productPiece2,14);
        PackedProductPiece threePiece = new PackedProductPiece(c,productPiece1,236);

        PackedProductSet one = new PackedProductSet(c,"Aceton",oneWeight,twoWeight,onePiece,twoPiece);
        PackedProductSet two = new PackedProductSet(b,"bor",one,threeWeight,threePiece);
        PackedProductSet three = new PackedProductSet(c,"|?");

        ConsignmentOfGoods party1 = new ConsignmentOfGoods("В Москву", one, threePiece,oneWeight);
        ConsignmentOfGoods party2 = new ConsignmentOfGoods("В Санкт-Петербург", two, twoPiece);
        ConsignmentOfGoods party3 = new ConsignmentOfGoods("В Санкт-Петербург", three);

        ProductService l = new ProductService();

        assertEquals(2,l.countByFilterDeep(party1));
        assertEquals(1,l.countByFilterDeep(party2));
        assertEquals(0,l.countByFilterDeep(party3));
    }
}