package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoEntity isPasswordMatch(String username, String password) {

        List<UserInfoEntity> list = userInfoDao.findByUsername(username);
        if(list != null && !list.isEmpty()) {
            for(UserInfoEntity user : list) {
                if(user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }
}
