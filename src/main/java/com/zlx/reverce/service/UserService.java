package com.zlx.reverce.service;

import com.zlx.reverce.dao.UserDao;
import com.zlx.reverce.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<Map> selectAll() {
        return userDao.selectAll();
    }

    public void insert(User user) {
        userDao.insertUser(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public void updateUserName(Long id, String name) {
        userDao.updateUserName(id, name);
    }

    public User findUser(String account, String password) {
        return userDao.findUser(account, password);
    }

    public User findUserById(String userId) {
        return userDao.findUserById(userId);
    }

}
