package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.RunTraceService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RunTraceServiceImpl implements RunTraceService {
    @Resource
    private RunTraceDao runTraceDao;

    @Override
    public List<RunTraceEntity> findAll() {
        return runTraceDao.findAll();
    }

    @Override
    public List<GPSPoint2V> findGPSPoint2VById(ObjectId id) {
        List<RunTraceEntity> runTraceList = runTraceDao.findById(id);
        if(runTraceList != null && !runTraceList.isEmpty()) {
            RunTraceEntity traceEntity = runTraceList.get(0);
            traceEntity.sort();
            return traceEntity.getGPSPoint2V();
        }
        return null;
    }
}
