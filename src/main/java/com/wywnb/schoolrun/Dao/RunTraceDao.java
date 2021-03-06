package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import org.bson.types.ObjectId;

import java.util.List;

public interface RunTraceDao {

    List<RunTraceEntity> findAll();

    List<RunTraceEntity> findById(ObjectId id);
}
