package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.NoticeEntity;
import com.wywnb.schoolrun.PO.NoticeEntityStringID;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    Map<String, String> insert(String title, String content, String username);
    List<NoticeEntityStringID> findAll();
    NoticeEntityStringID findByID(String id);
    Map<String, String> update(ObjectId id, String title, String content);
    Map<String, String> update(ObjectId id, boolean isValid);
}
