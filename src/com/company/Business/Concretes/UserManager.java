package com.company.Business.Concretes;

import com.company.Business.Abstracts.UserService;
import com.company.Core.AuthService;
import com.company.Entities.Concrete.User;
import com.company.dataAccess.Abstracts.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    private UserDao userDao;
    private AuthService authService;

    public UserManager(UserDao userDao, AuthService authService) {
        this.userDao = userDao;
        this.authService = authService;
    }

    @Override
    public void register(User user) {
        if(user.getPassword().length()<=6){
            System.out.println("Şifrenizi düzenleyin çünkü şifre en az 6 karakterden oluşmalıdır");
        }
        final String eMailPattern=("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        final Pattern pattern= Pattern.compile(eMailPattern);
        Matcher matcher=pattern.matcher(user.getEmail());
        if(!matcher.matches()) {
            System.out.println(user.getEmail()+ " bu e-posta istenen formatta değil");
        }
        for(User users: userDao.getAll()){
            if(users.getEmail().equals(user.getEmail())){
                System.out.println("Bu e-posta sistemde mevcuttur.");
            }
        }
        if(user.getFirstName().length()<=2 && user.getLastName().length()<=2){
            System.out.println("Ad ve Soyad en az iki karakterden oluşmalıdır");
        }
    }
    @Override
    public void login(User user) {
        if(user.isVerify()==true){
            userDao.login(user);
        }
        else
            System.out.println("Giriş başarısız olmuştur,kontrol ediniz");
    }

    @Override
    public void confirm(User user) {
        if(user.isVerify()==true){
            userDao.confirm(user);
            System.out.println(user.getFirstName()+" "+user.getLastName()+" e postanız doğrulanmıştır.");
        }
        else{
            System.out.println(user.getFirstName()+" "+ user.getLastName()+ " e-postanız doğrulanmadı");
        }
    }

    @Override
    public void registerWithAccount(User user) {
        user.setVerify(true);
        this.authService.register(user);
    }

    @Override
    public void loginWithAccount(User user) {
        if(user.isVerify()==true) {
            this.authService.login(user);
        }
        else{
            System.out.println("Henüz kayıt olmamış");
        }
    }


}
