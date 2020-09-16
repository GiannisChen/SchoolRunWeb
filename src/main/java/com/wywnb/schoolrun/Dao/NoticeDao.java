package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.NoticeEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface NoticeDao {
    Map<String, String> insert(NoticeEntity notice);
    List<NoticeEntity> findAll();
    Map<String, String> update(ObjectId id, String title, String content);
    Map<String, String> update(ObjectId id, boolean isValid);
    Map<String, String> delete(ObjectId id);
    List<NoticeEntity> findByID(ObjectId id);
}
