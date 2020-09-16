package com.wywnb.schoolrun.Dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.wywnb.schoolrun.Dao.NoticeDao;
import com.wywnb.schoolrun.Entity.NoticeEntity;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NoticeDaoImpl implements NoticeDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, String> insert(NoticeEntity notice) {
        Map<String, String> map = new HashMap<>();
        try {
            Object obj = mongoTemplate.save(notice);
            map.put("success", "OK");
        }
        catch (Exception e) {
            map.put("error", "fail to insert");
        }
        return map;
    }

    @Override
    public List<NoticeEntity> findAll() {
        return mongoTemplate.findAll(NoticeEntity.class);
    }

    @Override
    public Map<String, String> update(ObjectId id, String title, String content) {
        Map<String, String> map = new HashMap<>();
        try {
            Query query = new Query(Criteria.where("id").is(id));

            Update update = new Update();
            update.set("title", title);
            update.set("content", content);
            update.set("creatTime", Calendar.getInstance().getTime());
            mongoTemplate.updateFirst(query, update, NoticeEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "update error");
        }
        return map;
    }

    @Override
    public Map<String, String> update(ObjectId id, boolean isValid) {
        Map<String, String> map = new HashMap<>();
        try {
            Query query = new Query(Criteria.where("id").is(id));

            Update update = new Update();
            update.set("isValid", isValid);
            update.set("creatTime", Calendar.getInstance().getTime());
            mongoTemplate.updateFirst(query, update, NoticeEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "update error");
        }
        return map;
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        Map<String, String> map = new HashMap<>();
        Query query = new Query(Criteria.where("id").is(id));
        try {
            mongoTemplate.remove(query, NoticeEntity.class);
            map.put("success", "Ok");
        }
        catch (Exception e) {
            map.put("msg", "update error");
        }
        return map;
    }

    @Override
    public List<NoticeEntity> findByID(ObjectId id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, NoticeEntity.class);
    }
}
