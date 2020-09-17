package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.TraceEntityStringID;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface TraceService {
    List<TraceEntity> findAll();

    List<TraceEntityStringID> findAll2StringID();

    List<GPSPoint2V> findGPSPoint2VById(ObjectId id);

    Map<String, String> delete(ObjectId id);

    Long countAll();

    Long countDaily();
}
