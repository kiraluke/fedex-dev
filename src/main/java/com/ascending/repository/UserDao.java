package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User save(User user);
    boolean delete(User user);
    boolean deleteBy(String userName);
    User update(User user);
    List<Pack> getUserInfoAndPacksBy(String userName);
    User getUserByName(String userName);
    User getUserById(Long Id);
    User getUserByCredentials(String email,String password) throws Exception;
}
