package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.UserInfoEntity;

public interface UserInfoService {
    UserInfoEntity isPasswordMatch(String username, String password);
}
