package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.TraceDao;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.TraceEntityStringID;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
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
    public List<TraceEntityStringID> findAll2StringID() {
        List<TraceEntity> list = traceDao.findAll();
        if(list == null) {
            return null;
        }
        List<TraceEntityStringID> result = new LinkedList<>();
        for(TraceEntity old : list) {
            result.add(new TraceEntityStringID(old));
        }
        return result;
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
