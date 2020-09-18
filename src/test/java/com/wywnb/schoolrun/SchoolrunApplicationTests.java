package com.wywnb.schoolrun;

import com.wywnb.schoolrun.Dao.*;
import com.wywnb.schoolrun.Entity.*;
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
    private DailyPostDao dailyPostDao;

    @Test
    void contextLoads() {
        List<DailyPostEntity> list = dailyPostDao.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, List<DailyPostEntity>> test = list.stream().collect(Collectors.groupingBy(e -> sdf.format(new Date(e.getPostTime()))));
        System.out.println(test.toString());
    }
}
