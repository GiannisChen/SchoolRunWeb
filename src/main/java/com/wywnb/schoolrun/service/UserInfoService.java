package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.bson.types.ObjectId;

import java.util.Map;

public interface UserInfoService {
    UserInfoEntity isPasswordMatch(String username, String password);
    UserInfoEntity findOneByID(ObjectId id);
    Map<String, String> update(UserInfoEntity user);
    boolean codeExist(String code);
    Map<String, String> insert(UserInfoEntity user);
}
