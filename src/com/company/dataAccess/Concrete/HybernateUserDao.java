package com.company.dataAccess.Concrete;

import com.company.Entities.Concrete.User;
import com.company.dataAccess.Abstracts.UserDao;
import java.util.ArrayList;
import java.util.List;

public class HybernateUserDao implements UserDao {
    List<User> users=new ArrayList<User>();
    @Override
    public void register(User user) {
        System.out.println(user.getFirstName()+ " başarıyla kaydedildi ");
        users.add(user);
    }

    @Override
    public void login(User user) {
        System.out.println( user.getFirstName()+ " başarıyla giriş yaptı ");
        users.add(user);
    }

    @Override
    public void confirm(User user) {
        System.out.println("Sayın "+user.getFirstName()+" "+ user.getEmail()+ "onaylanmıştır");
        user.setVerify(true);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
