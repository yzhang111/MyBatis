package com.yzhan101.dao;

import com.yzhan101.pojo.User;

import java.util.List;

public interface UserDao {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert一个用户
    int insertUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}
