package com.company.Core;

import com.company.Entities.Concrete.User;
import com.company.GoogleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdaptor implements AuthService{
    private GoogleAuthManager googleAuthManager;

    public GoogleAuthManagerAdaptor(GoogleAuthManager googleAuthManager) {
        this.googleAuthManager = googleAuthManager;
    }

    @Override
    public void register(User user) {
        googleAuthManager.register(user);
    }

    @Override
    public void login(User user) {
        googleAuthManager.login(user);
    }
}
