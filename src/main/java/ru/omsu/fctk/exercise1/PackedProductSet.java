package ru.omsu.fctk.exercise1;

import java.util.Arrays;
import java.util.Objects;

public class PackedProductSet extends PackedProduct{
    private PackedProduct[] packedProduct;
    private String name;

    public PackedProductSet(Package pack,String name, PackedProduct ... packedProduct) {
        super(pack);
        this.packedProduct=new PackedProduct[packedProduct.length];
        for (int i = 0;i<packedProduct.length;i++) {
            this.packedProduct[i]=packedProduct[i];
        }
        this.name=name;
    }

    @Override
    public PackedProduct[] getProduct() {
        return packedProduct;
    }

    @Override
    public double getWeightNetto() {
        double sum = 0;
        for (PackedProduct p: packedProduct) {
            sum+=p.getWeightBrutto();
        }
        return sum;
    }

    @Override
    public double getWeightBrutto() {
        return getWeightNetto()+pack.getWeight();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder(super.toString());
        a.append("Название набора: " + name + "\n");
        a.append("{");
        for (PackedProduct p : packedProduct) {
            a.append("[");
            a.append(p.toString());
            a.append("]");
        }
        a.append("}");
        return a.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedProductSet that)) return false;
        if (!super.equals(o)) return false;
        return Arrays.equals(packedProduct, that.packedProduct) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), Arrays.hashCode(packedProduct));
    }
}
