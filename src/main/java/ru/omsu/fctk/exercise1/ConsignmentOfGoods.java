package ru.omsu.fctk.exercise1;

import java.util.Arrays;
import java.util.Objects;

public class ConsignmentOfGoods implements SaleWeightBrutto,ThingDescription{
    private String description;
    private PackedProduct[] packedProducts;


    public ConsignmentOfGoods(String description, PackedProduct ... packedProducts) {
        this.description = description;
        this.packedProducts = new PackedProduct[packedProducts.length];
        for (int i = 0; i < packedProducts.length; i++) {
            this.packedProducts[i]=packedProducts[i];
        }
    }


    @Override
    public double getWeightBrutto() {
        double sum=0;
        for (PackedProduct i:packedProducts) {
            sum+=i.getWeightBrutto();
        }
        return sum;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public PackedProduct[] getPackedProducts() {
        return packedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsignmentOfGoods that)) return false;
        return Objects.equals(getDescription(), that.getDescription()) && Arrays.equals(packedProducts, that.packedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), Arrays.hashCode(packedProducts));
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder("{");
        for (PackedProduct p : packedProducts) {
            a.append("[");
            a.append(p.toString());
            a.append("]");
        }
        a.append("}");
        return "Описание партии товаров: " + getDescription() + "\n" + a.toString();
    }


}
