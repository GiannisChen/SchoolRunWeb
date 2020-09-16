package com.wywnb.schoolrun.PO;

import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Data
public class BaseTraceEntityStringID {
    @Id
    private String id;
    private List<GPSPoint3V> trace;
    private String author;
    private String creatTime;

    public BaseTraceEntityStringID(BaseTraceEntity trace) {
        this.id = trace.getId().toHexString();
        this.author = trace.getAuthor();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.creatTime = sdf.format(trace.getCreateTime());
    }
}
