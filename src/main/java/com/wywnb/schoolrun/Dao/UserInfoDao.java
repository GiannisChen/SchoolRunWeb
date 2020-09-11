package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    Map<String, String> insert(UserInfoEntity user);
    Map<String, String> delete(ObjectId id);
    Map<String, String> update(UserInfoEntity user);
    List<UserInfoEntity> findAll();
    List<UserInfoEntity> findByUsername(String username);
    UserInfoEntity findByID(ObjectId id);
}
