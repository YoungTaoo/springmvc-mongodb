package com.young.taoo.dao;

import com.young.taoo.model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:springmvc-servlet.xml"})
public class UserDaoImplTest {

    private static Logger logger = Logger.getLogger(UserDaoImplTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void save(){
        User user = new User();
        user.setUsername("youngtaoo");
        user.setPassword("777777");
        userDao.saveUser(user);

        User User2 = userDao.findUserByName("youngtaoo");
        System.out.println("获取的用户密码为："+ User2.getPassword());
    }

    @Test
    public void updateTest(){
        User User = userDao.findUserByName("youngtaoo");
        logger.info("-------获取账户密码:-------" + User.getPassword());
        User.setPassword("99999999999");
        userDao.updateUser(User);
        logger.info("-------更新之后账户密码:-------" + User.getPassword());

    }

    @Test
    public void testPage(){
        List<User> useList = userDao.findListByPage(0,2);
        for (User User : useList){
            logger.info("-------user遍历:-------" + User.getUsername());
        }
    }

    @Test
    public void detele(){
        userDao.deteletUserById(userDao.findUserByName("youngtaoo").getId());
    }
}
