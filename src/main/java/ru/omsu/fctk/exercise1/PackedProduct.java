package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class PackedProduct implements SaleWeightNetto,SaleWeightBrutto{
    protected Package pack;

    public PackedProduct(Package pack) {
        this.pack = pack;
    }


    public double getWeightNetto(){return 0;};
    public double getWeightBrutto(){return 0;};
    public String getName(){return "";};
    public String toString(){return pack.toString();};

    public PackedProduct[] getProduct (){
        return new PackedProduct[]{new PackedProduct(new Package("", 0))};
    }

    @Override
    public int hashCode() {
        return Objects.hash(pack.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedProduct packedProduct)) return false;
        return Objects.equals(pack, packedProduct.pack);
    }
}
