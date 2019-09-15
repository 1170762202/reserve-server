package com.zlx.reverce.dao;

import com.zlx.reverce.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<Map> selectAll();

    List<Map> getAllByName(@Param("name") String name);

    void insertUser(@Param("user") User user);

    void deleteUser(@Param("id") Long id);

    void updateUserName(@Param("id") Long id, @Param("name") String name);

    User findUser(@Param("account") String account, @Param("password") String password);

    User findUserById(@Param("user_id") String user_id);
}

