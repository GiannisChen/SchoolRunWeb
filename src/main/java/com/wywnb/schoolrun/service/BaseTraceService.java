package com.wywnb.schoolrun.service;

import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface BaseTraceService {

    Map<String, String> insert(List<GPSPointAbbr2V> trace, String username);
    Map<String, String> delete(ObjectId id);
    List<GPSPoint2V> findGPSPoint2VById(ObjectId id);
}
