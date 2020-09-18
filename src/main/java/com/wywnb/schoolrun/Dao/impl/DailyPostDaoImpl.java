package com.wywnb.schoolrun.Dao.impl;

import com.wywnb.schoolrun.Dao.DailyPostDao;
import com.wywnb.schoolrun.Entity.DailyPostEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DailyPostDaoImpl implements DailyPostDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Long countAll() {
        Query query = new Query();
        return mongoTemplate.count(query, DailyPostEntity.class);
    }

    @Override
    public Long countDaily(Long startTime, Long endTime) {
        Query query = new Query(Criteria.where("postTime").gte(startTime).
                andOperator(Criteria.where("postTime").lt(endTime)));
        return mongoTemplate.count(query, DailyPostEntity.class);
    }

    @Override
    public List<DailyPostEntity> findAll() {
        return mongoTemplate.findAll(DailyPostEntity.class);
    }
}
