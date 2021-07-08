package com.company.GoogleAuth;

import com.company.Entities.Concrete.User;

public class GoogleAuthManager {
    public void register(User user){
        System.out.println("Sayın "+ user.getFirstName()+" "+user.getLastName()+" Google hesabı ile kayıt oldunuz ");
    }
    public void login(User user){
        System.out.println("Sayın " + user.getFirstName()+" "+user.getLastName()+ " Google hesabı ile giriş yaptınız ");
    }
}
