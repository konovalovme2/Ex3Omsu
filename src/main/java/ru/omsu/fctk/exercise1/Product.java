package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class Product
        implements ThingName,ThingDescription{
    private String name,description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public String toString() {
        return "Название товара: " + getName() + "\n" +
                "Описание товара: " + getDescription() + "\n";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
}
