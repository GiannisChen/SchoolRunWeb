package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.TraceDao;
import com.wywnb.schoolrun.Entity.NoticeEntity;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
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
public class TraceDaoImpl implements TraceDao {
    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public List<TraceEntity> findAll() {
        return mongoTemplate.findAll(TraceEntity.class);
    }

    @Override
    public List<TraceEntity> findById(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, TraceEntity.class);
    }

    @Override
    public Long getAllNum() {
        return mongoTemplate.count(new Query(), TraceEntity.class);
    }

    @Override
    public Long getAllByStudentId(Integer studentId) {
        Query query = new Query(Criteria.where("student_id").is(studentId));
        return mongoTemplate.count(query, TraceEntity.class);
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        Map<String, String> map = new HashMap<>();
        Query query = new Query(Criteria.where("id").is(id));
        try {
            mongoTemplate.remove(query, TraceEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "delete error");
        }
        return map;
    }
}
