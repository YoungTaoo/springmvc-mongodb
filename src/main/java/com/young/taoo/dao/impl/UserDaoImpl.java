package com.young.taoo.dao.impl;

import com.young.taoo.dao.UserDao;
import com.young.taoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    //MongoTemplate是数据库和代码之间的接口，对数据库的操作都在它里面
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> getUserAll() {
        return this.mongoTemplate.find(new Query(),User.class);
    }

    /**
     *  分页查询
     * @param skip(起始坐标)
     * @param limit(偏移量)
     * @return
     */
    @Override
    public List<User> findListByPage(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(new Order(Direction.ASC,"_id")));
        query.skip(skip).limit(limit);
        return this.mongoTemplate.find(query,User.class);
    }

    /**
     * 存储用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据id主键获取用户信息
     * @return
     */
    @Override
    public User findUserById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        return this.mongoTemplate.findOne(query,User.class);
    }

    /**
     * 根据用户名字查询用户
     * @param username
     * @return
     */
    @Override
    public User findUserByName(String username) {
        Query query = new Query();
        Criteria criteria = Criteria.where("username").is(username);
        query.addCriteria(criteria);
        return this.mongoTemplate.findOne(query,User.class);
    }

    /**
     * 根据用户实体修改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        Update update = new Update();
        Query query = new Query();
        update.set("username", user.getUsername());
        update.set("password", user.getPassword());
        this.mongoTemplate.updateFirst(query.addCriteria(Criteria.where("_id").is(user.getId())), update, User.class);
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    @Override
    public void deteletUserById(String id) {
        if (id == null ||id.length()==0){
            return;
        }
        Query query = new Query(Criteria.where("_id").is(id));
        this.mongoTemplate.remove(query,User.class);
    }
}
