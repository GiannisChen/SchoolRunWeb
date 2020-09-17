package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Dao.impl.UserInfoDaoImpl;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.service.UserInfoService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public UserInfoEntity findOneByID(ObjectId id) {
        return userInfoDao.findByID(id);
    }

    @Override
    public Map<String, String> update(UserInfoEntity user) {
        return userInfoDao.update(user);
    }

    @Override
    public boolean codeExist(String code) {
        UserInfoEntity user = userInfoDao.findByCode(code);
        return user != null && user.getInvitation_code() != null && !user.getInvitation_code().isEmpty();
    }

    @Override
    public Map<String, String> insert(UserInfoEntity user) {
        return userInfoDao.insert(user);
    }
}
