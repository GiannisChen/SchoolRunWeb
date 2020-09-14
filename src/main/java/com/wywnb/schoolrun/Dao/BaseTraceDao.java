package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface BaseTraceDao {

    Map<String, String> insert(BaseTraceEntity trace);
    List<BaseTraceEntity> findById(ObjectId id);
    Map<String, String> delete(ObjectId id);
}
