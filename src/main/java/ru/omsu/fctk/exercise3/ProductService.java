package ru.omsu.fctk.exercise3;

import ru.omsu.fctk.exercise1.PackedProductSet;
import ru.omsu.fctk.exercise1.PackedProduct;
import ru.omsu.fctk.exercise1.PackedProductWeight;
import ru.omsu.fctk.exercise2.Filter;
import ru.omsu.fctk.exercise1.ConsignmentOfGoods;

public class ProductService implements Filter {
    @Override
    public boolean apply(String keyWord) {
        if(keyWord.isEmpty() || (keyWord.charAt(0)>'Z' || keyWord.charAt(0)<'A')){
            return false;
        }
        for (int i = 1; i < keyWord.length(); i++) {
            if((keyWord.charAt(i)>'Z' || keyWord.charAt(i)<'A') && (keyWord.charAt(i)>'z' || keyWord.charAt(i)<'a')){
                return false;
            }
        }
        return true;
    }

    public int countByFilter(ConsignmentOfGoods party){
        int sum=0;
        for (int i = 0; i < party.getPackedProducts().length; i++) {
            if(apply(party.getPackedProducts()[i].getName())){
                sum++;
            }
        }
        return sum;
    }

    public int countByFilterDeep(ConsignmentOfGoods party){
        int sum=0;
        for (int i = 0; i < party.getPackedProducts().length; i++) {
            if(apply(party.getPackedProducts()[i].getName())){
                sum++;
            }
            else if (party.getPackedProducts()[i] instanceof PackedProductSet){
                if(SetFilterResult(party.getPackedProducts()[i].getProduct())){
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean SetFilterResult(PackedProduct[] set){
        for (PackedProduct packedProduct : set) {
            if (apply(packedProduct.getName())) {
                return true;
            }
            if (packedProduct instanceof PackedProductSet) {
                if (SetFilterResult(packedProduct.getProduct())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAllWeighted(ConsignmentOfGoods party){
        for (int i = 0; i < party.getPackedProducts().length; i++) {
            if(!(party.getPackedProducts()[i] instanceof PackedProductWeight)){
                return false;
            }
        }
        return true;
    }
}
