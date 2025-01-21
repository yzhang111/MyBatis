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
}
