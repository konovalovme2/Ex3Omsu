package ru.omsu.fctk.exercise2;

import java.util.Objects;

public class BeginStringFilter implements Filter{
    private String pattern;

    public BeginStringFilter(String pattern){
        this.pattern =pattern;
    }

    @Override
    public boolean apply(String keyWord) {
        return pattern.indexOf(keyWord)==0;
    }
}
