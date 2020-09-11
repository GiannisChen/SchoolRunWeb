package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserInfoDaoImpl implements UserInfoDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, String> insert(UserInfoEntity user) {
        Map<String, String> map = new HashMap<>();
        try {
            Object obj = mongoTemplate.save(user);
            map.put("success", "OK");
        }
        catch (Exception e) {
            map.put("msg", "insert error");
        }
        return map;
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        Map<String, String> map = new HashMap<>();
        try {
            Object obj = mongoTemplate.remove(id);
            map.put("success", "OK");
        }
        catch (Exception e) {
            map.put("msg", "delete error");
        }
        return map;
    }

    @Override
    public Map<String, String> update(UserInfoEntity user) {
        Map<String, String> map = new HashMap<>();
        try {
            Query query = new Query(Criteria.where("id").is(user.getId()));

            Update update = new Update();
            update.set("username", user.getUsername());
            update.set("password", user.getPassword());
            update.set("email", user.getEmail());
            update.set("isAdmin", user.getIsAdmin());

            mongoTemplate.updateFirst(query, update, UserInfoEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "update error");
        }
        return map;
    }

    @Override
    public List<UserInfoEntity> findAll() {
        List<UserInfoEntity> list = mongoTemplate.findAll(UserInfoEntity.class);
        return list;
    }

    @Override
    public List<UserInfoEntity> findByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        List<UserInfoEntity> list = mongoTemplate.find(query,UserInfoEntity.class);
        return list;
    }

    @Override
    public UserInfoEntity findByID(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        UserInfoEntity user = mongoTemplate.findOne(query,UserInfoEntity.class);
        return user;
    }
}
