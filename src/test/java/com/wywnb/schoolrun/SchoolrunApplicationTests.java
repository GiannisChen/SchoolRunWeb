package com.wywnb.schoolrun;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import com.wywnb.schoolrun.PO.GPSPoint2V;
import com.wywnb.schoolrun.service.TraceService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SchoolrunApplicationTests {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

    }
}
