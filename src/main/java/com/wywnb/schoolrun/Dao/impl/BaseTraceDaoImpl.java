package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.BaseTraceDao;
import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
    public List<BaseTraceEntity> findById(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, BaseTraceEntity.class);
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        Map<String, String> map = new HashMap<>();
        Query query = new Query(Criteria.where("id").is(id));
        try {
            mongoTemplate.remove(query, BaseTraceEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "delete error");
        }
        return map;
    }

    @Override
    public List<BaseTraceEntity> findAll() {
        return mongoTemplate.findAll(BaseTraceEntity.class);
    }
}
