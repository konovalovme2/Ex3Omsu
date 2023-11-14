package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class PackedProductWeight extends PackedProduct implements ThingWeight{
    ProductWeight prod;
    double weight;

    public PackedProductWeight(Package pack, ProductWeight prod, double weight) {
        super(pack);
        this.prod=prod;
        this.weight=weight;
    }

    @Override
    public String getName() {
        return prod.getName();
    }

    public ProductWeight getProdWeight() {
        return prod;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getWeightNetto() {
        return weight;
    }

    @Override
    public double getWeightBrutto() {
        return getWeightNetto()+pack.getWeight();
    }

    @Override
    public String toString() {
        return super.toString() + prod.toString() + "Масса товара в кг: " + weight + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedProductWeight that)) return false;
        if (!super.equals(o)) return false;
        return weight == that.weight && Objects.equals(prod, that.prod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prod, weight);
    }
}
