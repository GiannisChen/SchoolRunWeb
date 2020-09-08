package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
    Map<String, String> insertUserInfo(UserInfoEntity user);
    Map<String, String> deleteUserInfo(ObjectId id);
    Map<String, String> updateUserInfo(UserInfoEntity user);
    List<UserInfoEntity> findAll();
    List<UserInfoEntity> findByUsername(String username);
    UserInfoEntity findByID(ObjectId id);
}
