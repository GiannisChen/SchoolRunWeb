package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.TraceDao;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TraceServiceImpl implements TraceService {
    @Resource
    private TraceDao traceDao;

    @Override
    public List<TraceEntity> findAll() {
        return traceDao.findAll();
    }

    @Override
    public List<GPSPoint2V> findGPSPoint2VById(ObjectId id) {
        List<TraceEntity> traceList = traceDao.findById(id);
        if(traceList != null && !traceList.isEmpty()) {
            TraceEntity trace = traceList.get(0);
            trace.sort();
            return trace.getGPSPoint2V();
        }
        return null;
    }
}
