package com.wywnb.schoolrun.PO;

import com.wywnb.schoolrun.Entity.TraceEntity;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.List;

@Data
public class TraceEntityStringID {
    @Id
    private String id;
    private List<GPSPoint3V> trace;
    private Double distance;
    private Long time_cost;
    private String open_id;
    private Integer student_id;
    private String ip;
    private String date;
    private Double DTW;

    public TraceEntityStringID(TraceEntity trace) {
        this.id = trace.getId().toHexString();
        this.trace = trace.getTrace();
        this.distance = trace.getDistance();
        this.time_cost = trace.getTime_cost();
        this.open_id = trace.getOpen_id();
        this.student_id = trace.getStudent_id();
        this.ip = trace.getIp();
        this.DTW = trace.getDTW();
        StringBuffer date = new StringBuffer();
        if(trace.getMonth() < 10) {
            date.append("0");
        }
        date.append(trace.getMonth().toString()).append("-");
        if(trace.getDay() < 10) {
            date.append("0");
        }
        date.append(trace.getDay().toString());
        this.date = date.toString();
    }
}
