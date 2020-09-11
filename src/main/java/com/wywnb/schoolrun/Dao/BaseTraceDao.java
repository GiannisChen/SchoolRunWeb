package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import org.bson.types.ObjectId;

import java.util.Map;

public interface BaseTraceDao {

    Map<String, String> insert(BaseTraceEntity trace);
    Map<String, String> delete(ObjectId id);
}
