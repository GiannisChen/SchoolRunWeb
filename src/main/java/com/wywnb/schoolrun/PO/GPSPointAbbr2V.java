package com.wywnb.schoolrun.PO;

import lombok.Data;

@Data
public class GPSPointAbbr2V {
    private Double lat;
    private Double lng;

    public GPSPointAbbr2V(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public GPSPointAbbr2V(GPSPoint3V point3V) {
        if(point3V != null) {
            this.lat = point3V.getLatitude();
            this.lng = point3V.getLongitude();
        }
    }
}
