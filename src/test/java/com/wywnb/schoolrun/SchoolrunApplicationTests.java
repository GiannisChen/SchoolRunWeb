package com.wywnb.schoolrun;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SchoolrunApplicationTests {
    @Resource
    private TraceService traceService;

    @Test
    void contextLoads() {
        List<GPSPoint2V> list = traceService.findGPSPoint2VById(new ObjectId("5f44b7838a01a678171c1d10"));

        for(GPSPoint2V trace : list) {
            System.out.println(trace);
        }

    }
}
