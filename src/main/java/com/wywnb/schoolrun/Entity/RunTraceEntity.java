package com.wywnb.schoolrun.Entity;

import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.PO.GPSPoint3V;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Document(collection = "run_trace")
@Data
public class RunTraceEntity {

    @Id
    private ObjectId id;
    private List<GPSPoint3V> trace;

    public static final int ASC = 1;
    public static final int DESC = 2;

    public void sort(int order) {
        if(trace != null && !trace.isEmpty()) {
            if(order == 1) {
                trace.sort(new Comparator<GPSPoint3V>() {
                    @Override
                    public int compare(GPSPoint3V o1, GPSPoint3V o2) {
                        return o1.getTime().compareTo(o2.getTime());
                    }
                });
            }
            else if (order == 2) {
                trace.sort(new Comparator<GPSPoint3V>() {
                    @Override
                    public int compare(GPSPoint3V o1, GPSPoint3V o2) {
                        return o2.getTime().compareTo(o1.getTime());
                    }
                });
            }
        }
    }

    public void sort() {
        trace.sort(new Comparator<GPSPoint3V>() {
            @Override
            public int compare(GPSPoint3V o1, GPSPoint3V o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
    }

    public List<GPSPoint2V> getGPSPoint2V() {
        List<GPSPoint2V> result = new LinkedList<>();
        if(trace != null && !trace.isEmpty()) {
            for(GPSPoint3V point3V : trace) {
                result.add(new GPSPoint2V(point3V));
            }
        }
        return result;
    }
}
