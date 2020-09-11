package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.BaseTraceDao;
import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class BaseTraceDaoImpl implements BaseTraceDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, String> insert(BaseTraceEntity trace) {

        Map<String, String> map = new HashMap<>();
        try {
            Object obj = mongoTemplate.save(trace);
            map.put("success", "插入成功！");
        }
        catch (Exception e) {
            map.put("error", "插入出错！");
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
}
