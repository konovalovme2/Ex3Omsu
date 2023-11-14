package ru.omsu.fctk.exercise2;

public class IsEvenNumFilter implements Filter{
    @Override
    public boolean apply(String userPassword) {
        if(userPassword.isEmpty()){
            return false;
        }
        for (int i = 0; i < userPassword.length(); i++) {
            if(userPassword.charAt(i)>'9' || userPassword.charAt(i)<'0'){
                return false;
            }
        }
        return userPassword.charAt(userPassword.length()-1)=='0' || userPassword.charAt(userPassword.length()-1)=='2' || userPassword.charAt(userPassword.length()-1)=='4' || userPassword.charAt(userPassword.length()-1)=='6' || userPassword.charAt(userPassword.length()-1)=='8';
    }
}
