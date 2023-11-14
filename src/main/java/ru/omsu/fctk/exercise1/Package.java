package ru.omsu.fctk.exercise1;

import java.util.Objects;

public class Package implements ThingName,ThingWeight{
    private String name;
    private int weight;

    public Package(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Package pack)) return false;
        return Objects.equals(getName(), pack.getName()) && Objects.equals(getWeight(), pack.getWeight());
    }

    @Override
    public String toString() {
        return "Название упаковки: " + getName() + "\n" +
                "Масса упаковки: " + getWeight() + "\n";
    }
}
