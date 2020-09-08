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
    public List<GPSPoint2V> findGPSPoint2VById(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        List<RunTraceEntity> list = mongoTemplate.find(query, RunTraceEntity.class);
        List<GPSPoint2V> point2Vs = new ArrayList<>();

        if(list != null && !list.isEmpty()) {
            list.get(0).sort();
            point2Vs = list.get(0).getGPSPoint2V();
        }

        return point2Vs;
    }
}
