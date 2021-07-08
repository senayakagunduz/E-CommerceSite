package com.company.dataAccess.Abstracts;
import com.company.Entities.Concrete.User;

import java.util.List;

public interface UserDao {
    void register(User user);
    void login(User user);
    void confirm(User user);
    List<User> getAll();
}
