package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class ProductPiece extends Product implements ThingWeight{
    private double weightOne;
    public ProductPiece(String name, double weightOne,String description) {
        super(name, description);
        this.weightOne=weightOne;
    }

    @Override
    public double getWeight() {
        return weightOne;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName().hashCode(),getWeight(),super.getDescription().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPiece productPiece)) return false;
        return Objects.equals(getName(), productPiece.getName()) && Objects.equals(getWeight(), productPiece.getWeight()) && Objects.equals(getDescription(), productPiece.getDescription());
    }

    @Override
    public String toString() {
        return "Название товара: " + getName() + "\n" +
                "Масса одной единицы товара: " + getWeight() + "\n" +
                "Описание товара: " + getDescription() + "\n";
    }
}
