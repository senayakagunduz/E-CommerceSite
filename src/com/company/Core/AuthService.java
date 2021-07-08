package com.company.Core;

import com.company.Entities.Concrete.User;

public interface AuthService {
    void register(User user);
    void login(User user);
}
