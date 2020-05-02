package com.ascending.service;

import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.repository.UserDao;
import com.ascending.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User save(User user){
        return userDao.save(user);
    }
    public User update(User user){
        return userDao.update(user);
    }
    public boolean delete(String userName){
        return userDao.deleteBy(userName);
    }
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    public User getUserByName(String userName){
        return userDao.getUserByName(userName);
    }
    public User getUserById(Long Id){return userDao.getUserById(Id);}
//    public List<Pack> getUserInfoAndPacksBy(String userName){
//        return userDao.getUserInfoAndPacksBy(userName);
//    }

    public List<Pack> getUserInfoAndPacks(String userName){
        return userDao.getUserInfoAndPacksBy(userName);
    }

    public User getUserByCredentials(String email,String password) throws Exception {
        return userDao.getUserByCredentials(email, password);
    }
}
