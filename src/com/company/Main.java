package com.company;

import com.company.Business.Abstracts.UserService;
import com.company.Business.Concretes.UserManager;
import com.company.Core.GoogleAuthManagerAdaptor;
import com.company.Entities.Concrete.User;
import com.company.GoogleAuth.GoogleAuthManager;
import com.company.dataAccess.Concrete.HybernateUserDao;

public class Main {

    public static void main(String[] args) {
        UserService userService=new UserManager(new HybernateUserDao(),new GoogleAuthManagerAdaptor(new GoogleAuthManager()));
        User user1=new User("Ilknur","Denk","abc@gmail.com","123456",true);
        User user2=new User("Ahmet","Erdoğan","ahmt@gmail.com", "1234",false);
        userService.register(user1);
        userService.login(user1);
        userService.registerWithAccount(user2);
        userService.loginWithAccount(user2);
    }
}
