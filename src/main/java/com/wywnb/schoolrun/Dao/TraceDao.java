package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface TraceDao {
    List<TraceEntity> findAll();
    List<TraceEntity> findAllASC();
    List<TraceEntity> findById(ObjectId id);
    Long getAllNum();
    Long getAllByStudentId(Integer studentId);
    Map<String, String> delete(ObjectId id);
    Long countAll();
    Long countDaily(Long startTime, Long endTime);
}
