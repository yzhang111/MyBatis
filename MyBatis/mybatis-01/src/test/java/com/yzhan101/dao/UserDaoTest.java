package com.yzhan101.dao;

import com.yzhan101.pojo.User;
import com.yzhan101.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        //第一步：获得SQLSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.getUserList();

        //方式二：不推荐
//        List<User> list = sqlSession.selectList("com.yzhan101.dao.UserDao.getUserList");

        for (User user : list) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改查需要提交事务
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.insertUser(new User(4, "testUser", "123333"));
        if (res > 0) {
            System.out.println("插入成功");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestUpdateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.updateUser(new User(4, "testUser1", "123333"));
        if (res > 0) {
            System.out.println("修改成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestDeleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int res = userDao.deleteUser(4);
        if (res > 0) {
            System.out.println("删除成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
