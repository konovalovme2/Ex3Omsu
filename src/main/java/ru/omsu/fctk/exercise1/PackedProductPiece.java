package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class PackedProductPiece extends PackedProduct implements ThingPieceCount{
    private ProductPiece prod;
    private int pieces;

    @Override
    public String getName() {
        return prod.getName();
    }

    public PackedProductPiece(Package pack, ProductPiece prod, int pieces) {
        super(pack);
        this.prod=prod;
        this.pieces=pieces;
    }

    public ProductPiece getProdPiece() {
        return prod;
    }

    @Override
    public int getPiece() {
        return pieces;
    }

    @Override
    public double getWeightNetto() {
        return pieces*prod.getWeight();
    }

    @Override
    public double getWeightBrutto() {
        return getWeightNetto()+pack.getWeight()*pieces;
    }

    @Override
    public String toString() {
        StringBuilder k = new StringBuilder(super.toString());
        k.append(prod.toString());
        k.append("Кол-во товара в шт.: " + pieces + "\n");
        return k.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedProductPiece that)) return false;
        if (!super.equals(o)) return false;
        return pieces == that.pieces && Objects.equals(prod, that.prod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prod, pieces);
    }
}
