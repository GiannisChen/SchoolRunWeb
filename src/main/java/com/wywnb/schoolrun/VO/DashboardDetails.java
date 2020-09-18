package com.wywnb.schoolrun.VO;

import com.wywnb.schoolrun.Entity.DailyPostEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Data
public class DashboardDetails {
    private Long traceTotalNum;
    private Long postTotalNum;
    private Long traceDailyNum;
    private Long postDailyNum;
    private Map<String, Long> traceCalendar;
    private Map<String, Long> postCalendar;

    public void setTraceCalendar(Map<String, List<TraceEntity>> trace) {
        this.traceCalendar = new HashMap<>();
        for(Map.Entry<String, List<TraceEntity>> entry : trace.entrySet()){
            this.traceCalendar.put(entry.getKey(), (long) entry.getValue().size());
        }
    }

    public void setPostCalendar(Map<String, List<DailyPostEntity>> post) {
        this.postCalendar = new HashMap<>();
        for(Map.Entry<String, List<DailyPostEntity>> entry : post.entrySet()){
            this.postCalendar.put(entry.getKey(), (long) entry.getValue().size());
        }
    }
}
