package com.young.taoo.dao;

import com.young.taoo.model.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> getUserAll();

    /**
     *  分页查询
     * @param skip(起始坐标)
     * @param limit(偏移量)
     * @return
     */
    public List<User> findListByPage(int skip, int limit);

    /**
     * 存储用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据id主键获取用户信息
     * @return
     */
    public User findUserById(String id);

    /**
     * 根据用户名字查询用户
     * @param username
     * @return
     */
    public User findUserByName(String username);

    /**
     * 根据用户实体修改用户信息
     * @param userEntity
     */
    public void updateUser(User userEntity);

    /**
     * 根据用户id删除用户
     * @param id
     */
    public void deteletUserById(String id);
}
