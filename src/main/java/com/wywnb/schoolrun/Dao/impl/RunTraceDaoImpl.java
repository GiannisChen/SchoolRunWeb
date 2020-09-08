package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunTraceDaoImpl implements RunTraceDao {
    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public List<RunTraceEntity> findAll() {
        return mongoTemplate.findAll(RunTraceEntity.class);
    }

    @Override
    public List<RunTraceEntity> findById(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, RunTraceEntity.class);
    }
}
