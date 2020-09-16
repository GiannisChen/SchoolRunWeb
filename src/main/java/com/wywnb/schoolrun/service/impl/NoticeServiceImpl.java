package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.NoticeDao;
import com.wywnb.schoolrun.Entity.NoticeEntity;
import com.wywnb.schoolrun.PO.NoticeEntityStringID;
import com.wywnb.schoolrun.service.NoticeService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    @Override
    public Map<String, String> insert(String title, String content, String username) {
        NoticeEntity notice = new NoticeEntity(title, content, username);
        return noticeDao.insert(notice);
    }

    @Override
    public List<NoticeEntityStringID> findAll() {
        List<NoticeEntity> oldList = noticeDao.findAll();
        List<NoticeEntityStringID> newList = new LinkedList<>();
        if(oldList != null) {
            for(NoticeEntity notice : oldList) {
                newList.add(new NoticeEntityStringID(notice));
            }
        }
        return newList;
    }

    @Override
    public NoticeEntityStringID findByID(String id) {
        List<NoticeEntity> temp = noticeDao.findByID(new ObjectId(id));
        if(temp == null || temp.isEmpty()) {
            return null;
        }
        return new NoticeEntityStringID(temp.get(0));
    }

    @Override
    public Map<String, String> update(ObjectId id, String title, String content) {
        return noticeDao.update(id, title, content);
    }

    @Override
    public Map<String, String> update(ObjectId id, boolean isValid) {
        return noticeDao.update(id, isValid);
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        return noticeDao.delete(id);
    }
}
