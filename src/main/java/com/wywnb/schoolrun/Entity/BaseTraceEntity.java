package com.wywnb.schoolrun.Entity;

import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPointAbbr2V;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Document("base_trace")
@Data
public class BaseTraceEntity {

    private ObjectId id;
    private String author;
    private Timestamp createTime;
    private List<GPSPoint2V> trace;

    public BaseTraceEntity(List<GPSPointAbbr2V> trace, String username) {
        this.author = username;
        this.trace = new LinkedList<>();
        for(GPSPointAbbr2V point : trace) {
            this.trace.add(new GPSPoint2V(point));
        }
    }
}
