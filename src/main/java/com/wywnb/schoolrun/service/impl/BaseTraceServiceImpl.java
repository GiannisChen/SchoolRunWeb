package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.BaseTraceDao;
import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import com.wywnb.schoolrun.service.BaseTraceService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
public class BaseTraceServiceImpl implements BaseTraceService {

    @Resource
    private BaseTraceDao baseTraceDao;

    @Override
    public Map<String, String> insert(List<GPSPointAbbr2V> trace, String username) {
        BaseTraceEntity baseTrace = new BaseTraceEntity(trace, username);
        baseTrace.setCreateTime(Calendar.getInstance().getTime());
        return baseTraceDao.insert(baseTrace);
    }

    @Override
    public Map<String, String> delete(ObjectId id) {
        return baseTraceDao.delete(id);
    }

    @Override
    public List<GPSPoint2V> findGPSPoint2VById(ObjectId id) {
        List<BaseTraceEntity> traceList = baseTraceDao.findById(id);
        if(traceList != null && !traceList.isEmpty()) {
            return traceList.get(0).getTrace();
        }
        return null;
    }
}
