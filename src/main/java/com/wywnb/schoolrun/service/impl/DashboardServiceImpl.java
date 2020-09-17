package com.wywnb.schoolrun.service.impl;

import com.wywnb.schoolrun.Dao.TraceDao;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.VO.DashboardDetails;
import com.wywnb.schoolrun.VO.DayCount;
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

    @Override
    public DashboardDetails getDetails() {
        DashboardDetails details = new DashboardDetails();
        List<TraceEntity> traceList = traceDao.findAllASC();

        Long temp = traceDao.countAll();
        details.setTraceTotalNum(temp == null ? 0L : temp);
        details.setPostTotalNum(0L);

        Map<String, Long> map = new HashMap<>();

        Calendar cur = Calendar.getInstance();
        cur.set(Calendar.HOUR_OF_DAY, 0);
        cur.set(Calendar.MINUTE, 0);
        cur.set(Calendar.SECOND, 0);
        cur.set(Calendar.MILLISECOND, 0);
        Long startTime = cur.getTimeInMillis();
        cur.add(Calendar.DATE, 1);
        Long endTime = cur.getTimeInMillis();

        temp = traceDao.countDaily(startTime, endTime);
        details.setTraceDailyNum(temp == null ? 0L : temp);
        details.setPostDailyNum(0L);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        details.setTraceCalendar(traceList.stream()
                .collect(Collectors.groupingBy(e -> sdf.format(new Date(e.getPostTime())))));

        return details;
    }
}
