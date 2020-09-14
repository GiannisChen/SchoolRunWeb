package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.TraceEntityStringID;
import org.bson.types.ObjectId;

import java.util.List;

public interface TraceService {
    List<TraceEntity> findAll();

    List<TraceEntityStringID> findAll2StringID();

    List<GPSPoint2V> findGPSPoint2VById(ObjectId id);
}
