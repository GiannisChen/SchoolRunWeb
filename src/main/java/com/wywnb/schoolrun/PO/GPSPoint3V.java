package com.wywnb.schoolrun.PO;

import lombok.Data;

import java.util.Date;

@Data
public class GPSPoint3V {
    private Double latitude;
    private Double longitude;
    private Date time;
}
