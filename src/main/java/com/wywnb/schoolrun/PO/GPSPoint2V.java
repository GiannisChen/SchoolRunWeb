package com.wywnb.schoolrun.PO;

import lombok.Data;

@Data
public class GPSPoint2V {
    private Double latitude;
    private Double longitude;

    public GPSPoint2V(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GPSPoint2V(GPSPoint3V point3V) {
        if(point3V != null) {
            this.latitude = point3V.getLatitude();
            this.longitude = point3V.getLongitude();
        }
    }
}
