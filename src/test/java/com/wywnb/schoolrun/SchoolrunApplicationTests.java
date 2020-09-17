package com.wywnb.schoolrun;

import com.wywnb.schoolrun.Dao.*;
import com.wywnb.schoolrun.Entity.BaseTraceEntity;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.TraceEntity;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class SchoolrunApplicationTests {

    @Resource
    private TraceDao traceDao;

    @Test
    void contextLoads() {
        List<TraceEntity> list = traceDao.findAllASC();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, List<TraceEntity>> test = list.stream().collect(Collectors.groupingBy(e -> sdf.format(new Date(e.getPostTime()))));
        System.out.println(test.toString());
    }
}
