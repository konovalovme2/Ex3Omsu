package ru.omsu.fctk.exercise2;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PasswordFilter implements Filter{
    @Override
    public boolean apply(String userPassword) {
        if(userPassword.isEmpty()){
            return false;
        }
        for (int i = 0; i < userPassword.length(); i++) {
            if((userPassword.charAt(i)>'Z' || userPassword.charAt(i)<'A') && (userPassword.charAt(i)>'z' || userPassword.charAt(i)<'a') && (userPassword.charAt(i)>'9' || userPassword.charAt(i)<'0')){
                return false;
            }
        }
        return true;
    }
}
