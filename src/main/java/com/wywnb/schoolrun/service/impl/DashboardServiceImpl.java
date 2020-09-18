package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.DailyPostDao;
import com.wywnb.schoolrun.Dao.TraceDao;
import com.wywnb.schoolrun.Entity.DailyPostEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.VO.DashboardDetails;
import com.wywnb.schoolrun.service.DashboardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Resource
    private TraceDao traceDao;
    @Resource
    private DailyPostDao dailyPostDao;

    @Override
    public DashboardDetails getDetails() {
        DashboardDetails details = new DashboardDetails();
        List<TraceEntity> traceList = traceDao.findAllASC();
        List<DailyPostEntity> postList = dailyPostDao.findAll();

        Long temp1 = traceDao.countAll();
        Long temp2 = dailyPostDao.countAll();
        details.setTraceTotalNum(temp1 == null ? 0L : temp1);
        details.setPostTotalNum(temp2 == null ? 0L : temp2);

        Calendar cur = Calendar.getInstance();
        cur.set(Calendar.HOUR_OF_DAY, 0);
        cur.set(Calendar.MINUTE, 0);
        cur.set(Calendar.SECOND, 0);
        cur.set(Calendar.MILLISECOND, 0);
        Long startTime = cur.getTimeInMillis();
        cur.add(Calendar.DATE, 1);
        Long endTime = cur.getTimeInMillis();

        temp1 = traceDao.countDaily(startTime, endTime);
        temp2 = dailyPostDao.countDaily(startTime, endTime);
        details.setTraceDailyNum(temp1 == null ? 0L : temp1);
        details.setPostDailyNum(temp2 == null ? 0L : temp2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        details.setTraceCalendar(traceList.stream()
                .collect(Collectors.groupingBy(e -> sdf.format(new Date(e.getPostTime())))));
        details.setPostCalendar(postList.stream()
                .collect(Collectors.groupingBy(e -> sdf.format(new Date(e.getPostTime())))));
        return details;
    }
}
